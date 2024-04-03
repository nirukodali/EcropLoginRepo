package com.ecrops.partitions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.ecrops.entity.EmployeeList;
import com.ecrops.entity.PhyAckVwise;

@Repository
@Transactional
public class EmployeeListPartition {

	@PersistenceContext
	private EntityManager entityManager;

	public List<EmployeeList> getEmpList(String dcode, String mcode, String cropyear) {

		String[] season = cropyear.split("@");
		System.out.println("season=========" + season);
		String seasonType = season[0];
		System.out.println("seasonType=========" + seasonType);
		Integer seasonYear = Integer.parseInt(season[1]);
		System.out.println("seasonYear=========" + seasonYear);

		String tableName;
		String tableName1;
		String tableName2;
		if (seasonYear >= 2023) {
			tableName = "ecrop" + seasonYear + "." + "cr_emp_profile";
			tableName1 = "ecrop" + seasonYear + "." + "emp_rbk_map";
			tableName2 =   "vill_sec_det";

		} else {
			
			tableName = "cr_emp_profile";
			tableName1 = "emp_rbk_map";
			tableName2 = "vill_sec_det";

		}

		System.out.println("tableName---------------->" + tableName);
		System.out.println("tableName1---------------->" + tableName1);
		System.out.println("tableName2---------------->" + tableName2);

		String Sql = "select c.vname,rbkuserid, a.emp_code,emp_name,cast(case when designation='1' then 'VAA' when designation='2'\r\n"
				+ "then 'VHA' when designation='3' then 'VSA' end as varchar) as designation,mobile,email,\r\n"
				+ "cast('xxxxxxxx'||right(aadhaar_id,4) as varchar) as aadhaar_id from  " + tableName + " a , \r\n" + "  "
				+ tableName1 + " b," + tableName2 + "  c where  a.dcode=b.dcode and a.mcode=b.mcode \r\n"
				+ "and b.dcode=c.dcode and b.mcode=c.mcode and b.rbkcode=c.vcode and  a.emp_code=b.empcode and a.dcode=?\r\n"
				+ "and a.mcode=? order by vname ";

		Query insertQuery = (Query) entityManager.createNativeQuery(Sql);
		insertQuery.setParameter(1, Integer.parseInt(dcode));
		insertQuery.setParameter(2, Integer.parseInt(mcode));

		List<Object[]> detailsEntities1 = insertQuery.getResultList();
		// System.out.println("detailsEntities1=>"+detailsEntities1.size());
		// System.out.println("detailsEntities1=>"+detailsEntities1.toString());
		List<EmployeeList> detailsEntities = new ArrayList<EmployeeList>();

		for (Object[] row : detailsEntities1) {

			EmployeeList entity = new EmployeeList();

			entity.setVname((String) row[0]);
			entity.setRbkuserid((String) row[1]);
			entity.setEmp_code((Integer) row[2]);
			entity.setEmp_name((String) row[3]);
			entity.setDesignation((String) row[4]);
			entity.setMobile((BigDecimal) row[5]);
			entity.setEmail((String) row[6]);
			entity.setAadhaar_id((String) row[7]);
			detailsEntities.add(entity);

		}

		return detailsEntities;

	}

}
