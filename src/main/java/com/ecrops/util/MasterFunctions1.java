package com.ecrops.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ecrops.entity.CropBookingDetailsMaoIntf;
import com.ecrops.entity.RepPernnialMand;
import com.ecrops.util.entity.MasterFunctionsEntity;

@Repository
@Transactional
public class MasterFunctions1 {
	@PersistenceContext
	private EntityManager entityManager;

	public List<MasterFunctionsEntity>  getCropImageMao( 
			String wbdcode, String bookingid, 
			String cropyear, String tseason, 
			String cr_crop,String Year)
            throws SQLException {
		
		System.out.println("wbdcode=>"+wbdcode);
		System.out.println("bookingid=>"+bookingid);
		System.out.println("cropyear=>"+cropyear);
		System.out.println("tseason=>"+tseason);
		System.out.println("cr_crop=>"+cr_crop);
		System.out.println("Year=>"+Year);
		
		String[] season = cropyear.split("@");
		System.out.println("season========="+season);
		String cseason = season[0];
		System.out.println("cseason========="+cseason);
		Integer Yearr = Integer.parseInt(season[1]);
		System.out.println("Year========="+Year);
		
		String part_key = "",part_key1="";
		
		if (Integer.parseInt(wbdcode) > 9) {
			part_key = cseason + wbdcode + Year;
			System.out.println("part_key==========>"+part_key);
		} else {
			part_key = cseason + "0" + wbdcode + Year; 
			System.out.println("part_key==========>"+part_key);
		}
		
        String   tableName ="ecrop" + Year + "." +"cr_images_" + part_key ;
     
		System.out.println("tableName---------------->" + tableName);

		String Sql = " select photo from " + tableName + " where bookingid=? and cr_crop=?";

		Query insertQuery = (Query) entityManager.createNativeQuery(Sql);
		insertQuery.setParameter(1, Long.parseLong(bookingid));
		insertQuery.setParameter(2, Integer.parseInt(cr_crop));
	
		List<Object[]> detailsEntities1 = insertQuery.getResultList();
		System.out.println("detailsEntities1=>"+detailsEntities1.size());
		//System.out.println("detailsEntities1=>"+detailsEntities1.toString());
		List<MasterFunctionsEntity> detailsEntities = new ArrayList<MasterFunctionsEntity>();
	

		for (Object[] row : detailsEntities1) {
			
			MasterFunctionsEntity entity = new MasterFunctionsEntity();
			entity.setPhoto((String) row[0].toString());
			
			
			detailsEntities.add(entity);
		}
		return detailsEntities;

	}


}
