package com.ecrops.partitions;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ecrops.entity.PhyAckVwise;
import com.ecrops.entity.Rep_phy_ack_rbk;

@Repository
@Transactional
public class Rep_phy_ack_rbkPartition {
	@PersistenceContext
	private EntityManager entityManager;

	public List<Rep_phy_ack_rbk> getPhyRbk( String wbdcode,String wbmcode,String cropyear,String userid) {
		
		
		String[] season = cropyear.split("@");
		System.out.println("season========="+season);
		String seasonType = season[0];
		System.out.println("seasonType========="+seasonType);
		Integer seasonYear = Integer.parseInt(season[1]);
		System.out.println("seasonYear========="+seasonYear);
	
		

		String part_key = "";
//		if (Integer.parseInt(wbdcode) > 9) {
//			part_key = seasonType + wbdcode + seasonYear;	 System.out.println("part_key==========>"+part_key);
//		} else {
//			part_key = seasonType + "0" + wbdcode + seasonYear; System.out.println("part_key==========>"+part_key);
//		}
		part_key = seasonType  + seasonYear; System.out.println("part_key==========>"+part_key);
		
		String tableName = "ecrop" + seasonYear + "." + "ekycgenerated_rbk_mv_" + part_key; 
		String tableName1 = "ecrop" + seasonYear + "." + "cr_authdetails_rbk_mv_" + part_key; 

		System.out.println("tableName---------------->" + tableName);

		String Sql = "select c.rbkname,coalesce(c.ekycfarmercount,0) \r\n"
				+ "as ekycfarmercount, coalesce(a.totfarmers,0) as ackcount,cast(c.cr_dist_code  as character varying) as wbdcode,\r\n"
				+ "cast(c.cr_mand_code as character varying) as wbmcode,a.addedby as text,\r\n"
				+ "c.dname as wbdname,c.mname as wbmname,\r\n"
				+ "a.addedby as rbkcode from "+tableName+" a right join "+tableName1+" \r\n"
				+ "c on c.rbkcode=substr(a.addedby, 5)  where c.cr_dist_code=?  and a.wbmcode=? ";

		Query insertQuery = (Query) entityManager.createNativeQuery(Sql);
		insertQuery.setParameter(1, Integer.parseInt(wbdcode));
		insertQuery.setParameter(2, Integer.parseInt(wbmcode));
		
	
		List<Object[]> detailsEntities1 = insertQuery.getResultList();
		//System.out.println("detailsEntities1=>"+detailsEntities1.size());
		//System.out.println("detailsEntities1=>"+detailsEntities1.toString());
		List<Rep_phy_ack_rbk> detailsEntities = new ArrayList<Rep_phy_ack_rbk>();
		

		for (Object[] row : detailsEntities1) {

			Rep_phy_ack_rbk entity = new Rep_phy_ack_rbk();
			
			entity.setRbkname((String) row[0]);
			entity.setEkycfarmercount(Long.valueOf(row[1].toString()));
			entity.setAckcount(Long.valueOf(row[2].toString()));
			detailsEntities.add(entity);

		}
		
		return detailsEntities;

	}
	

}
