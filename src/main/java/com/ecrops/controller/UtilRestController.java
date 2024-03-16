package com.ecrops.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecrops.config.RegularExpressionclassMethod;
import com.ecrops.entity.AllocatedSurveyNoMapping;
import com.ecrops.entity.AuthMAOvaaVroEkyc;
import com.ecrops.entity.CropBookingDetailsMaoIntf;

import com.ecrops.entity.CropwiseExtBookedRBKwise;
import com.ecrops.entity.DataSourceWiseBookingReport;
import com.ecrops.entity.FarmerBookingDetails;
import com.ecrops.entity.MaoAuthVaaVroekyc;
import com.ecrops.entity.MaoSocialAuditcorrection;
import com.ecrops.entity.NormalAreasMwiseMao;
import com.ecrops.entity.PhyAckVwise;
import com.ecrops.entity.RbkSurveyNoMapping;
import com.ecrops.entity.RbkSurveyNoMappingDrpdwn;
import com.ecrops.entity.RepLandDataDetails;
import com.ecrops.entity.RepPernnialMand;
import com.ecrops.entity.Rep_DownloadedDetailsIntf;
import com.ecrops.entity.Rep_phy_ack_rbk;
import com.ecrops.entity.RofrBookedExtent;
import com.ecrops.entity.RofrBookedExtentPartitions;
import com.ecrops.entity.SeasonCropBookedExtent;
import com.ecrops.entity.SpuperChkAppr;
import com.ecrops.entity.SuperCheckRecordsAlloted;
import com.ecrops.entity.SuperChkReport;
import com.ecrops.entity.SuperChk_rejReport;
import com.ecrops.entity.SupercheckVill;
import com.ecrops.entity.Superchekupdstatus;
import com.ecrops.model.RequestModel;
import com.ecrops.partitions.AllocatedSurveyNoMappingPartition;
import com.ecrops.partitions.AuthMAOvaaVroEkycPartition;
import com.ecrops.partitions.CropBookingDetailsMaoIntfPartition;
import com.ecrops.partitions.CropwiseExtBookedRBKwisePartition;
import com.ecrops.partitions.DataSourceWiseBookingReportPartitions;
import com.ecrops.partitions.PhyAckVwisePartition;
import com.ecrops.partitions.RbkSurveyNoMappingDrpdwnPartitions;
import com.ecrops.partitions.RepPernnialMandPartition;
import com.ecrops.partitions.Rep_DownloadedDetailsIntfPartition;
import com.ecrops.partitions.Rep_phy_ack_rbkPartition;
import com.ecrops.partitions.SeasonCropBookedExtentPartition;
import com.ecrops.partitions.SpuperChkApprPartition;
import com.ecrops.partitions.SuperCheckRecordsAllotedPartition;
import com.ecrops.partitions.SuperChkReportPartition;
import com.ecrops.partitions.SuperChk_rejReportPartition;
import com.ecrops.partitions.SuperchekupdstatusPartition;
import com.ecrops.projections.MasterProjections;
import com.ecrops.repo.AllocataedSurveyNoMappingRepo;

import com.ecrops.repo.FarmerBookingDetailsPartitions;
import com.ecrops.repo.FarmerBookingDetailsRepo;
import com.ecrops.repo.MaoAuthVaaVroekycPartition;
import com.ecrops.repo.MaoAuthVaaVroekycRepo;
import com.ecrops.repo.MaoSocialAuditcorrectionRepo;
import com.ecrops.repo.NormalAreasMwiseMaoRepo;
import com.ecrops.repo.RbkSurveyNoMappingPartition;
import com.ecrops.repo.RbkSurveyNoMappingRepo;
import com.ecrops.repo.RepLandDataDetailsRepo;
import com.ecrops.repo.RofrBookedExtentRepo;
import com.ecrops.repo.RofrBookedExtentRepo.EfishDetailsC;
import com.ecrops.repo.RofrBookedExtentRepo.EfishDetailsR;
import com.ecrops.repo.RofrBookedExtentRepo.FarmerDetails;
import com.ecrops.repo.SeasonCropBookedExtentRepo;
import com.ecrops.repo.SeasonCropBookedExtentRepo.BlockedEfishExtent;
import com.ecrops.repo.SeasonCropBookedExtentRepo.CropInsAbstractt;
import com.ecrops.repo.SeasonCropBookedExtentRepo.CropInsGrievance;
import com.ecrops.repo.SeasonCropBookedExtentRepo.DeviceRegDetails;
import com.ecrops.repo.SeasonCropBookedExtentRepo.EmployeeList;
import com.ecrops.repo.SeasonCropBookedExtentRepo.NonWebView;
import com.ecrops.repo.SeasonCropBookedExtentRepo.ObjUnobj;
import com.ecrops.repo.SeasonCropBookedExtentRepo.RepVaaDetails;
import com.ecrops.repo.SupercheckVillRepo;
import com.ecrops.util.MasterFunctions;


@RestController

@RequestMapping("/util")
public class UtilRestController {
	@Autowired
	SeasonCropBookedExtentRepo seasonCropBookedExtentRepo;

	@Autowired
	private NormalAreasMwiseMaoRepo normalAreasMwiseMaoRepo;
	
	@Autowired
	private FarmerBookingDetailsPartitions partition;
	@Autowired
	private RofrBookedExtentPartitions rofrBookedExtentPartitions;
	@Autowired
	private MaoAuthVaaVroekycRepo maoAuthVaaVroekycRepo;
	@Autowired
	private MaoAuthVaaVroekycPartition maoAuthVaaVroekycPartition;
	
	@Autowired
	private RbkSurveyNoMappingPartition rbkSurveyNoMappingPartition;

	

	@GetMapping("/getAllSeason")
	public List<MasterProjections> getAllSeasonn() {
		List<MasterProjections> list = normalAreasMwiseMaoRepo.getAllSeason();
		return list;
	}

	@GetMapping("/getAllCrop")
	public List<MasterProjections> getAllCrop() {
		List<MasterProjections> list = maoAuthVaaVroekycRepo.getAllCrops();
		return list;
	}

	@GetMapping("/getAllMandals")
	public List<MasterProjections> getMandals(Integer dcode) {
		List<MasterProjections> list = seasonCropBookedExtentRepo.getAllMandals(dcode);
		return list;
	}

//**************************************************//Villages//*************************************************
	@GetMapping("/getAllVillages")
	public List<MasterProjections> getVillages(Integer dcode, Integer mcode) {
		System.out.println("dcode=>" + dcode);
		System.out.println("mcode=>" + mcode);
		List<MasterProjections> list = seasonCropBookedExtentRepo.getAllVillages(dcode, mcode);
		return list;
	}
//===========================CropGroups=================================//

	@GetMapping("/getCropGroup")
	public List<MasterProjections> getCropGroup() {
		System.out.println("=======getCropGroup==========");
		List<MasterProjections> list = seasonCropBookedExtentRepo.getAllCropGrp();
		System.out.println("=======list==========" + list.size());
		return list;
	}

	// ===============getAllCrpGrp=====================//
	@GetMapping("/getCropGroupid")
	public List<MasterProjections> getCropGoupidd(String grpcode) {
		List<MasterProjections> list = seasonCropBookedExtentRepo.getAllCrpGrpid(Integer.parseInt(grpcode));
		System.out.println("=======list==========" + list.size());
		return list;
	}

	// ==================Normal Area Report====================//
	@GetMapping("/getNormarlAreaReport")
	List<NormalAreasMwiseMao> getList(String dcode, String mcode, String cropyear) {

		String[] season = cropyear.split("@");
		String seasonType = season[0];
		Integer seasonYear = Integer.parseInt(season[1]);
		

		Integer ddcode = Integer.parseInt(dcode);
		Integer mmcode = Integer.parseInt(mcode);

		RegularExpressionclassMethod  regexpressionmethod=new RegularExpressionclassMethod();
	    boolean val= regexpressionmethod.districtCode(ddcode.toString());
		boolean year= regexpressionmethod.year(seasonYear.toString());
		boolean season1= regexpressionmethod.season(seasonType.toString());
	
	if(val && year && season1) {
		List<NormalAreasMwiseMao> listt = normalAreasMwiseMaoRepo.getListt(ddcode, mmcode, seasonType, seasonYear);
		
		//System.out.println("list size=>" + listt.size());
		//System.out.println("list =>" + listt.toString());
		return listt;
	   }
	
	return null; 
	}

// <-------------FARMER BOOKING DETAILS----------->
//	@GetMapping("/getFbDetails")
//	List<FarmerBookingDetails> getFarmers(String dcode, String mcode, String cropyear, HttpSession session,
//			String userid) {
//		String[] season = cropyear.split("@");
//		String seasonType = season[0];
//		String year = season[1];
//		Integer seasonYear = Integer.parseInt(season[1]);
//
//		Integer ddcode = Integer.parseInt(dcode);
//		Integer mmcode = Integer.parseInt(mcode);
//		String wbdcode = (String) session.getAttribute("wbdcode");
//
//		List<FarmerBookingDetails> Farmerlist = partition.farmerBookingDetails(dcode, mcode, year, wbdcode);
//
//		return Farmerlist;
//	}

	@GetMapping("/getFbDetails1")
	List<FarmerBookingDetails> getFbDetails(String dcode, String mcode, String cropyear, String wbdcode,
			String userid) {
		
		String[] season = cropyear.split("@");
		String seasonType = season[0];
		Integer seasonYear = Integer.parseInt(season[1]);
		
		RegularExpressionclassMethod  regexpressionmethod=new RegularExpressionclassMethod();
	    boolean val= regexpressionmethod.districtCode(dcode.toString());
	    boolean val1= regexpressionmethod.mandalCode(mcode.toString());
		boolean year= regexpressionmethod.year(seasonYear.toString());
		
	
	if(val && val1 && year) {

		List<FarmerBookingDetails> list = partition.farmerBookingDetails(dcode, mcode, cropyear, wbdcode);
		System.out.println("details===================>" + list.size());

		return list;
	}
	return null;
	}
	// <------------------ROFR BOOKED EXTENT----------------->//

	@GetMapping("/getRofr")
	List<RofrBookedExtent> getRbExt(String wbcode, String wbmcode, String cropyear, HttpSession session,
			String userid) {
		String[] season = cropyear.split("@");
		String seasonType = season[0];
		String year = season[1];
		Integer seasonYear = Integer.parseInt(season[1]);
		String wbdcode = (String) session.getAttribute("wbdcode");

		List<RofrBookedExtent> rofrList = rofrBookedExtentPartitions.rofrbext(wbdcode, wbmcode, year);

		return rofrList;
	}

	@GetMapping("/getRofr1")
	List<RofrBookedExtent> getRext(String wbdcode, String wbmcode, String cropyear, String userid) {
//		System.out.println("dcode===================>" + dcode);
//		System.out.println("mcode===================>" + mcode);
//		System.out.println("cropyear===================>" + cropyear);
//		System.out.println("wbdcode===================>" + wbdcode);
	String[] season = cropyear.split("@");
	String seasonType = season[0];
	String year = season[1];
	Integer seasonYear = Integer.parseInt(season[1]);
	
	RegularExpressionclassMethod  regexpressionmethod=new RegularExpressionclassMethod();


    boolean val= regexpressionmethod.districtCode(wbdcode.toString());
    boolean val1= regexpressionmethod.mandalCode(wbmcode.toString());
	boolean year1= regexpressionmethod.year(year.toString());
	boolean season1= regexpressionmethod.season(seasonType.toString());
	System.out.println("year------------->"+year);

System.out.println("val-------------->"+val);
System.out.println("season1-------------->"+season1);

if(val && val1&& year1 && season1) {
	
		List<RofrBookedExtent> rofr = rofrBookedExtentPartitions.rofrbext(wbdcode, wbmcode, cropyear);
		System.out.println("details===================>" + rofr.size());

		return rofr;
	}
return null;
}
	// <------------------MaoAuthVaaVroEkyc----------------->//
	@GetMapping("/getekyc1")
	List<MaoAuthVaaVroekyc> getEkycVaaVro(String wbdcode, String cropyear, String mcode, String userid, String cropid) {
		String[] season = cropyear.split("@");
		String seasonType = season[0];
		String year = season[1];
		Integer seasonYear = Integer.parseInt(season[1]);
		
		RegularExpressionclassMethod  regexpressionmethod=new RegularExpressionclassMethod();

	    boolean val= regexpressionmethod.districtCode(wbdcode.toString());
		boolean year1= regexpressionmethod.year(year.toString());
		boolean season1= regexpressionmethod.season(seasonYear.toString());
	
	if(val && year1 && season1) {
		List<MaoAuthVaaVroekyc> ekyc = maoAuthVaaVroekycPartition.vaaVroEkyc(wbdcode, mcode, cropyear, cropid);
		System.out.println("details===================>" + ekyc.size());
		return ekyc;
	}
	return null;
	}
	// <------------------MaoRbkSurveyNoMapping----------------->//

	@GetMapping("/rbk")
	List<RbkSurveyNoMapping> getSurveyNo(String wbdcode, String cropyear, HttpSession session, String mcode,
			String userid) {
		String[] season = cropyear.split("@");
		String seasonType = season[0];
		String year = season[1];

		// Integer ddcode = Integer.parseInt(dcode);
		// Integer mmcode = Integer.parseInt(mcode);
		// String wbdcode = (String) session.getAttribute("wbdcode");

		// List<MaoAuthVaaVroekyc> ekycList =
		// maoAuthVaaVroekycPartition.vaaVroEkyc(wbdcode, year,mcode);

		return null;
	}

	@GetMapping("/rbk1")
	List<RbkSurveyNoMapping> getRbkSno(String wbdcode, String cropyear, String mcode, String userid, String updatedby) {

		System.out.println("wbdcode===================>" + wbdcode);
		System.out.println("mcode===================>" + mcode);
		System.out.println("cropyear===================>" + cropyear);
		System.out.println("userid===================>" + userid);
		
		String[] season = cropyear.split("@");
		String seasonType = season[0];
		String year = season[1];
		Integer seasonYear = Integer.parseInt(season[1]);
		
		RegularExpressionclassMethod  regexpressionmethod=new RegularExpressionclassMethod();

	    boolean val= regexpressionmethod.districtCode(wbdcode.toString());System.out.println("val====>"+val);
	    boolean val1= regexpressionmethod.mandalCode(mcode.toString());System.out.println("val1====>"+val1);
		boolean year1= regexpressionmethod.year(year.toString());System.out.println("year1====>"+year1);
	
	if(val && val1 && year1) {
		

		List<RbkSurveyNoMapping> sno = rbkSurveyNoMappingPartition.rbkSno(wbdcode, mcode, cropyear, userid, userid);
		System.out.println("details===================>" + sno.size());

		return sno;
	}
	return null;
	}

	// <------------------AllocatedSurveyNoMapping----------------->//
	@Autowired
	private AllocatedSurveyNoMappingPartition allocatedSurveyNoMappingPartition;
	@Autowired
	private RbkSurveyNoMappingDrpdwnPartitions rbkSurveyNoMappingDrpdwnPartitions;

	@GetMapping("/drpd")
	List<RbkSurveyNoMappingDrpdwn> getRbkdrpd(String mcode, String cropyear, String wbdcode, String rbkcode,
			HttpSession session, HttpServletRequest request) {
		System.out.println("mcode==========>" + mcode);
		System.out.println("cropyear==========>" + cropyear);
		System.out.println("wbdcode==========>" + wbdcode);
		System.out.println("rbkcode==========>" + rbkcode);

		String[] season = cropyear.split("@");
		String seasonType = season[0];
		String year = season[1];
		cropyear = request.getParameter("cropyear");
		// mcode= (String) session.getAttribute("mcode");
		// wbdcode= (String) session.getAttribute("wbdcode");
		// rbkcode= (String) session.getAttribute("rbkcode");

		List<RbkSurveyNoMappingDrpdwn> aldw = rbkSurveyNoMappingDrpdwnPartitions.getRBK(mcode, cropyear, wbdcode,
				rbkcode);
		System.out.println("details------>" + aldw.size());

		return aldw;
	}
//----------------Allocated SurveryNo Mapping--------------------//

	@GetMapping("/asnom1")
	List<AllocatedSurveyNoMapping> getAllocSnoMapping(String wbdcode, String cropyear, String mcode, String userid,
			String rbkid) {
		String[] season = cropyear.split("@");
		String seasonType = season[0];
		String year = season[1];

		RegularExpressionclassMethod  regexpressionmethod=new RegularExpressionclassMethod();

	    boolean val= regexpressionmethod.districtCode(wbdcode.toString());
	    boolean valm= regexpressionmethod.mandalCode(mcode.toString());
		boolean year1= regexpressionmethod.year(year.toString());
		boolean season1= regexpressionmethod.season(seasonType.toString());
	
	if(val && valm && year1 && season1) {

		List<AllocatedSurveyNoMapping> asno = allocatedSurveyNoMappingPartition.allocatedSnoDetails(wbdcode, cropyear,
				mcode, userid, rbkid);
		System.out.println("details===================>" + asno.size());
		return asno;
	}
	return null;
	}
	// *******// DataSourceWiseBookingExtent//*******//
	@Autowired
	DataSourceWiseBookingReportPartitions dataSourceWiseBookingReportPartitions;
	@GetMapping("/dtsrcb1")
	List<DataSourceWiseBookingReport> dataSrcDet(String wbdcode, String cropyear, String wbmcode, String userid) {

		System.out.println("wbdcode===================>" + wbdcode);
		System.out.println("cropyear===================>" + cropyear);
		System.out.println("userid===================>" + userid);
		String[] season = cropyear.split("@");
		String seasonType = season[0];
		String year = season[1];
		
		RegularExpressionclassMethod  regexpressionmethod=new RegularExpressionclassMethod();

	    boolean val= regexpressionmethod.districtCode(wbdcode.toString());
	    boolean wbmcd= regexpressionmethod.mandalCode(wbmcode.toString());
		boolean year1= regexpressionmethod.year(year.toString());
		boolean season1= regexpressionmethod.season(seasonType.toString());
	
	if(val && year1 && season1&&wbmcd) {

		List<DataSourceWiseBookingReport> dsb = dataSourceWiseBookingReportPartitions.dataSrcDet(wbdcode, cropyear,
				wbmcode, userid);
		System.out.println("details===================>" + dsb.get(0));
		return dsb;
	}
	return null;
}
// **********************efishDetails***************************
	@Autowired
	private RofrBookedExtentRepo rofrBookedExtentRepo;

	@GetMapping("/efishDetails")
	public ResponseEntity<?> efishDetails(@RequestParam("dataSrc") String dataSrc,
			@RequestParam("dcode") String dcode, 
			@RequestParam("mcode") String mcode) {
		
		RegularExpressionclassMethod  regexpressionmethod=new RegularExpressionclassMethod();

	    boolean val= regexpressionmethod.districtCode(dcode.toString());
	    boolean wbmcd= regexpressionmethod.mandalCode(mcode.toString());
		
	
	if(val && wbmcd) {
		if (dataSrc.equalsIgnoreCase("R")) {
			List<EfishDetailsR> efishDetailsR = rofrBookedExtentRepo.efishDetailsR(dataSrc, Integer.parseInt(dcode),
					Integer.parseInt(mcode));
			return new ResponseEntity<List<EfishDetailsR>>(efishDetailsR, HttpStatus.OK);
		}
		if (dataSrc.equalsIgnoreCase("C")) {
			List<EfishDetailsC> efishDetailsC = rofrBookedExtentRepo.efishDetailsC(Integer.parseInt(dcode),
					Integer.parseInt(mcode));
			return new ResponseEntity<List<EfishDetailsC>>(efishDetailsC, HttpStatus.OK);
		}
		return null;
	}
	return null;
	}
	// **************** Farmer Details****************
@GetMapping("/farmerdet")
	public ResponseEntity<?> farmerdet(@RequestParam("mcode") String mcode, @RequestParam("date") 
	String date,String cropyear) {
		String[] season = cropyear.split("@");
		String seasonType = season[0];
		String year = season[1];
		
		RegularExpressionclassMethod  regexpressionmethod=new RegularExpressionclassMethod();

	    
	    boolean wbmcd= regexpressionmethod.mandalCode(mcode.toString());
		boolean year1= regexpressionmethod.year(year.toString());
		boolean season1= regexpressionmethod.season(seasonType.toString());
	
	if( year1 && season1&&wbmcd) {
		
		List<FarmerDetails> farmerDetails = rofrBookedExtentRepo.farmerDetails(Integer.parseInt(mcode), date);
		return new ResponseEntity<List<FarmerDetails>>(farmerDetails, HttpStatus.OK);
	}
	return null;
	}
	// **************************************************************************//
	@Autowired
	SeasonCropBookedExtentPartition seasonCropBookedExtentPartition;

	@GetMapping("/allcrp1")
	List<SeasonCropBookedExtent> getAllCrop(String wbmcode, String cropyear, String userid, String wbdcode) {

		String[] season = cropyear.split("@");
		String seasonType = season[0];
		String year = season[1];
		
		RegularExpressionclassMethod  regexpressionmethod=new RegularExpressionclassMethod();
	    
		boolean wbdcd= regexpressionmethod.districtCode(wbdcode.toString());
	    boolean wbmcd= regexpressionmethod.mandalCode(wbmcode.toString());
		boolean year1= regexpressionmethod.year(year.toString());
	if( year1 && wbdcd&&wbmcd) {

		List<SeasonCropBookedExtent> scp = seasonCropBookedExtentPartition.getAllCrops(wbmcode, cropyear, userid,
				wbdcode);
		System.out.println("details===================>" + scp.get(0));
		return scp;
	}
	return null;}
//=============================BLOCKED e-fish EXTENT============================//

	@GetMapping("/blockedext")
	public ResponseEntity<?> blockedext(@RequestParam("dcode") String dcode, 
			@RequestParam("mcode") String mcode,
			@RequestParam("vcode") String wbvcode) {
		System.out.println("blockedext");
		System.out.println("dcode=>" + dcode);
		System.out.println("mcode=>" + mcode);
		System.out.println("wbvcode=>" + wbvcode);

		Integer parsedDcode = Integer.parseInt(dcode);
		Integer parsedMcode = Integer.parseInt(mcode);
		Integer parsedWbvcode = Integer.parseInt(wbvcode);
		
		RegularExpressionclassMethod  regexpressionmethod=new RegularExpressionclassMethod();

	    
	    boolean dcode1= regexpressionmethod.districtCode(parsedDcode.toString());
	    boolean mcode1= regexpressionmethod.mandalCode(parsedMcode.toString());
	    boolean wbvcode1= regexpressionmethod.villageCode(parsedWbvcode.toString());
		
	
	if( dcode1 && mcode1&&wbvcode1) {
	
		List<BlockedEfishExtent> blockedExtent = seasonCropBookedExtentRepo.findByExtent(parsedDcode, parsedMcode,
				parsedWbvcode);

		return new ResponseEntity<>(blockedExtent, HttpStatus.OK);
	}
	return null;
}
//===========OBJ-UNOBJ//

	@GetMapping("/objunobj1")
	public ResponseEntity<?> getObj() {
		List<ObjUnobj> Objunobj = seasonCropBookedExtentRepo.getObjObj();

		return new ResponseEntity<List<ObjUnobj>>(Objunobj, HttpStatus.OK);
	}

///======================EMP LIST=======================///
	@GetMapping("/emplist")
	public ResponseEntity<?> getEmp(@RequestParam("dcode") String dcode,
			@RequestParam("mcode") String mcode) {
		Integer ddcode = Integer.parseInt(dcode);
		Integer mmcode = Integer.parseInt(mcode);

		try {
			RegularExpressionclassMethod regexpressionmethod = new RegularExpressionclassMethod();

			boolean val = regexpressionmethod.districtCode(ddcode.toString());
			boolean val2 = regexpressionmethod.mandalCode(mmcode.toString());

			System.out.println("val-------------->" + val);
			System.out.println("val2-------------->" + val2);

			if (val && val2) {
			
			List<EmployeeList> emplist = seasonCropBookedExtentRepo.getEmpList(Integer.parseInt(dcode),
					Integer.parseInt(mcode));
			return new ResponseEntity<List<EmployeeList>>(emplist, HttpStatus.OK);
}
		} catch (NumberFormatException e) {
			System.out.println("Exception"+e);
			e.printStackTrace();
		}
		return null;
		
	}	
	
	@GetMapping("/vaadet")
	public ResponseEntity<?> getVAADet(@RequestParam("mcode") String mcode, String userid) {
		RegularExpressionclassMethod regexpressionmethod = new RegularExpressionclassMethod();
		
		boolean val1 = regexpressionmethod.mandalCode(mcode.toString());
		System.out.println("val-------------->" + val1);

		if (val1){
		
		List<RepVaaDetails> vaadet = seasonCropBookedExtentRepo.getVaaDet(mcode);
		return new ResponseEntity<List<RepVaaDetails>>(vaadet, HttpStatus.OK);
	}
		return null;
	}

//--------------------------------- Device Reg Details-----------------------------------------------//
	@PostMapping("/devregdet")
	public ResponseEntity<?> getDevRegDetails(@RequestBody RequestModel requestModel) {
		System.out.println("requestModel=>" + requestModel.toString());

		List<DeviceRegDetails> devregdet;
		try {
			String[] season = requestModel.getCropyear().split("@");
			String seasonType = season[0];
			Integer seasonYear = Integer.parseInt(season[1]);
			
			RegularExpressionclassMethod regexpressionmethod = new RegularExpressionclassMethod();
			boolean mcode=	regexpressionmethod.mandalCode(requestModel.getMcode());
			boolean   saesonid=		regexpressionmethod.year(seasonYear.toString());
			if(mcode && saesonid) {
			devregdet = seasonCropBookedExtentRepo.getDevRegDet(requestModel.getMcode(), 
					                                         seasonYear, 
					                                         seasonType);
			System.out.println("devregdet size=>" + devregdet.size());
			return new ResponseEntity<List<DeviceRegDetails>>(devregdet, HttpStatus.OK);
			}
		} catch (Exception e) {
			System.out.println("getStackTrace =>" + e.getStackTrace());
		}
		return null;

	}

//---------------------------------- Crop Insurence Grievance---------------------------------------------//
	@PostMapping("/crpinsgri")
	public ResponseEntity<?> getCropInsGri(@RequestBody RequestModel requestModel) {
		System.out.println("requestModel=>" + requestModel.toString());
		
		String[] season = requestModel.getCropyear().split("@");
		String cseason = season[0];
		Integer Year = Integer.parseInt(season[1]);
		RegularExpressionclassMethod regexpressionmethod = new RegularExpressionclassMethod();
		boolean dcode=	regexpressionmethod.districtCode(requestModel.getDcode());
		boolean mcode=	regexpressionmethod.mandalCode(requestModel.getMcode());
		boolean   saesonid=		regexpressionmethod.year(Year.toString());
		if(mcode && saesonid &&dcode) {

		try {
			

			List<CropInsGrievance> crpins = seasonCropBookedExtentRepo.getCropIns(
					Integer.parseInt(requestModel.getDcode()), 
					Integer.parseInt(requestModel.getMcode()), 
					Year,
					cseason);
			System.out.println("crpins size=>" + crpins.size());
			return new ResponseEntity<List<CropInsGrievance>>(crpins, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block

			System.out.println("getStackTrace =>" + e.getStackTrace());
			return null;
		}
	}
		return null;}

//================================ SperCheck Allotment Records==========================================//
	@Autowired
	private SuperCheckRecordsAllotedPartition superCheckRecordsAllotedPartition;

	@PostMapping("/supchkalltrecrds")
	List<SuperCheckRecordsAlloted> getSupChkR(@RequestBody RequestModel requestModel) {
		System.out.println("requestModel=>" + requestModel.toString());
		String[] season = requestModel.getCropyear().split("@");
		String cseason = season[0];
		Integer Year = Integer.parseInt(season[1]);
		
		RegularExpressionclassMethod regexpressionmethod = new RegularExpressionclassMethod();
		boolean wbdcode=	regexpressionmethod.districtCode(requestModel.getWbdcode());
		boolean wbmcode=	regexpressionmethod.mandalCode(requestModel.getWbmcode());
		boolean   saesonid=		regexpressionmethod.year(Year.toString());
		if(wbdcode && wbmcode &&saesonid) {
		List<SuperCheckRecordsAlloted> spckr = superCheckRecordsAllotedPartition.getSupchkRds(
				requestModel.getWbdcode(),
				requestModel.getWbmcode(), 
				requestModel.getUserid(), 
				requestModel.getCropyear());
		System.out.println("details===================>" + spckr.size());
		return spckr;
	}
		return null;
	}
//================SpuperCheck APPR Report==================//
	@Autowired
	SpuperChkApprPartition spuperChkApprPartition;

	@PostMapping("/supchapprintf")
	List<SpuperChkAppr> getSupChkAppr(@RequestBody RequestModel requestModel) {
		System.out.println("requestModel=>" + requestModel.toString());
		String[] season = requestModel.getCropyear().split("@");
		String cseason = season[0];
		Integer Year = Integer.parseInt(season[1]);
		
		RegularExpressionclassMethod regexpressionmethod = new RegularExpressionclassMethod();
		boolean wbdcode=	regexpressionmethod.districtCode(requestModel.getWbdcode());
		boolean wbmcode=	regexpressionmethod.mandalCode(requestModel.getWbmcode());
		boolean   saesonid=		regexpressionmethod.year(Year.toString());
		if(wbdcode && wbmcode &&saesonid) {
		List<SpuperChkAppr> spcapr = spuperChkApprPartition.getSupchkAppr(
				requestModel.getWbdcode(),
				requestModel.getWbmcode(), 
				requestModel.getUserid(),
				requestModel.getCropyear());
		System.out.println("details===================>" + spcapr.size());
		return spcapr;
	}
		return null;
		}
//=========================SuperCheck Report===============================//

	@Autowired
	SuperChkReportPartition superChkReportPartition;

	@PostMapping("/supcheckReport")
	List<SuperChkReport> getSupChk(@RequestBody RequestModel requestModel) {
		System.out.println("requestModel=>" + requestModel.toString());
		String[] season = requestModel.getCropyear().split("@");
		String cseason = season[0];
		Integer Year = Integer.parseInt(season[1]);
		
		RegularExpressionclassMethod regexpressionmethod = new RegularExpressionclassMethod();
		boolean wbdcode=	regexpressionmethod.districtCode(requestModel.getWbdcode());
		boolean wbmcode=	regexpressionmethod.mandalCode(requestModel.getWbmcode());
		boolean   saesonid=		regexpressionmethod.year(Year.toString());
		if(wbdcode && wbmcode &&saesonid) {
		List<SuperChkReport> supkr = superChkReportPartition.getSupchkRep(
				requestModel.getWbdcode(),
				requestModel.getWbmcode(),
				requestModel.getUserid(), 
				requestModel.getCropyear());
		System.out.println("details===================>" + supkr.size());
		return supkr;
	}
		return null;}
//========================== SuperCheck Rejected===============================//

	@Autowired
	SuperChk_rejReportPartition superChk_rejReportPartition;

//@Autowired MasterFunctions masterFunctions;

	@PostMapping("/supchkrej")
	List<SuperChk_rejReport> getSupChkRejrReport(@RequestBody RequestModel requestModel) {
		System.out.println("requestModel=>" + requestModel.toString());

		// masterFunctions.getCropImageMao(null, null, null, null, null, null)
		String[] season = requestModel.getCropyear().split("@");
		String cseason = season[0];
		Integer Year = Integer.parseInt(season[1]);
		
		RegularExpressionclassMethod regexpressionmethod = new RegularExpressionclassMethod();
		boolean wbdcode=	regexpressionmethod.districtCode(requestModel.getWbdcode());
		boolean wbmcode=	regexpressionmethod.mandalCode(requestModel.getWbmcode());
		boolean   saesonid=		regexpressionmethod.year(Year.toString());
		if(wbdcode && wbmcode &&saesonid) {

		List<SuperChk_rejReport> supkrej = superChk_rejReportPartition.getSupchkRej(
				requestModel.getWbdcode(),
				requestModel.getWbmcode(),
				// requestModel.getUserid(),
				requestModel.getCropyear());
		System.out.println("details===================>" + supkrej.size());
		return supkrej;
	}
		return null;}
	// ================CropBookingDetailsMaoIntf====================//

	@Autowired
	CropBookingDetailsMaoIntfPartition cropBookingDetailsMaoIntfPartition;

	@Autowired
	MasterFunctions masterFunctions;

	@PostMapping("/crpmao")
	List<CropBookingDetailsMaoIntf> getCropdetMao(@RequestBody RequestModel requestModel) throws SQLException {
		System.out.println("requestModel=>" + requestModel.toString());
		
		String[] season = requestModel.getCropyear().split("@");
		String seasonType = season[0];
		Integer seasonYear = Integer.parseInt(season[1]);
		
		RegularExpressionclassMethod regexpressionmethod = new RegularExpressionclassMethod();
		boolean dcode=	regexpressionmethod.districtCode(requestModel.getDcode());System.out.println("dcode--->"+dcode);
		boolean mcode=	regexpressionmethod.mandalCode(requestModel.getWbmcode());System.out.println("mcode--->"+mcode);
		boolean vcode=	regexpressionmethod.villageCode(requestModel.getVcode());System.out.println("vcode--->"+vcode);
		boolean  year=		regexpressionmethod.year(seasonYear.toString());System.out.println("year--->"+year);
		if(dcode && vcode &&mcode && year) {

		List<CropBookingDetailsMaoIntf> crdbmao = cropBookingDetailsMaoIntfPartition.getCropDetailsMao(
				requestModel.getWbdcode(), 
				requestModel.getDcode(), 
				requestModel.getWbmcode(), 
				requestModel.getVcode(),
				requestModel.getCropyear(),
				requestModel.getCrop());
		System.out.println("details===================>" + crdbmao.size());
		return crdbmao;
	}
		return null;
	}
	// ================PhyAckVwise====================//
	@Autowired
	PhyAckVwisePartition phyAckVwisePartition;

	@PostMapping("/phyack")
	List<PhyAckVwise> getPhyAckVwise(@RequestBody RequestModel requestModel) throws SQLException {
		System.out.println("requestModel=>" + requestModel.toString());
		String[] season = requestModel.getCropyear().split("@");
		String cseason = season[0];
		Integer Year = Integer.parseInt(season[1]);
		
		RegularExpressionclassMethod regexpressionmethod = new RegularExpressionclassMethod();
		boolean wbdcode=	regexpressionmethod.districtCode(requestModel.getWbdcode());
		boolean wbmcode=	regexpressionmethod.mandalCode(requestModel.getWbmcode());
		boolean   saesonid=		regexpressionmethod.year(Year.toString());
		if(wbdcode && wbmcode &&saesonid) {

		List<PhyAckVwise> phyack = phyAckVwisePartition.getPhyAck(
				requestModel.getWbdcode(), 
				requestModel.getWbmcode(),
				requestModel.getCropyear(), 
				requestModel.getUserid());
		return phyack;
	}
		return null;
	}
	// ================ Rep_phy_ack_rbk====================//
	@Autowired
	Rep_phy_ack_rbkPartition rep_phy_ack_rbkPartition;

	@PostMapping("/phyrbk")
	List<Rep_phy_ack_rbk> getPhyAckRBK(@RequestBody RequestModel requestModel) throws SQLException {
		System.out.println("requestModel=>" + requestModel.toString());
		String[] season = requestModel.getCropyear().split("@");
		String cseason = season[0];
		Integer Year = Integer.parseInt(season[1]);
		
		RegularExpressionclassMethod regexpressionmethod = new RegularExpressionclassMethod();
		boolean wbmcode=	regexpressionmethod.mandalCode(requestModel.getWbmcode());
		boolean   saesonid=		regexpressionmethod.year(Year.toString());
		if(wbmcode &&saesonid) {
		List<Rep_phy_ack_rbk> phyrbk = rep_phy_ack_rbkPartition.getPhyRbk(requestModel.getWbdcode(),
				requestModel.getWbmcode(),
				requestModel.getCropyear(),
				requestModel.getUserid());
		System.out.println("details===================>" + phyrbk.size());
		return phyrbk;
	}
		return null;}
//==========================Rep_DownloadedDetailsIntf===========================//
	@Autowired
	Rep_DownloadedDetailsIntfPartition rep_DownloadedDetailsIntfPartition;

	@PostMapping("/dwnlddet")
	List<Rep_DownloadedDetailsIntf> getDwnloadedDet(@RequestBody RequestModel requestModel,
			HttpSession httpSession)
			throws SQLException {
		System.out.println("requestModel=>" + requestModel.toString());
		System.out.println(httpSession.getAttribute("wbdname"));
		
		String[] season = requestModel.getCropyear().split("@");
		String seasonType = season[0];
		Integer seasonYear = Integer.parseInt(season[1]);
		
		RegularExpressionclassMethod regexpressionmethod = new RegularExpressionclassMethod();
		boolean wbdcode=	regexpressionmethod.districtCode(requestModel.getWbdcode());
		boolean wbmcode=	regexpressionmethod.mandalCode(requestModel.getWbmcode());
		boolean   saesonid=		regexpressionmethod.year(seasonYear.toString());
		if(wbdcode&& wbmcode && saesonid) {
		

		List<Rep_DownloadedDetailsIntf> dwnlddet = rep_DownloadedDetailsIntfPartition.getDwnLdDet(
				requestModel.getWbdcode(), requestModel.getWbmcode(), requestModel.getCropyear(),
				requestModel.getUserid());
		System.out.println("details===================>" + dwnlddet.size());
		return dwnlddet;
	}
		return null;
	}
//=====================RepLandDataDetails=========================//
 	@Autowired
	RepLandDataDetailsRepo repLandDataDetailsRepo;

	@PostMapping("/landatam")
	List<RepLandDataDetails> getDwnloadedDet(@RequestBody RequestModel requestModel) throws SQLException {
		System.out.println("requestModel=>" + requestModel.toString());
		String[] season = requestModel.getCropyear().split("@");
		String seasonType = season[0];
		Integer seasonYear = Integer.parseInt(season[1]);
		
		RegularExpressionclassMethod regexpressionmethod = new RegularExpressionclassMethod();
		boolean dcode=	regexpressionmethod.districtCode(requestModel.getDcode());
		boolean mcode=	regexpressionmethod.mandalCode(requestModel.getMcode());
		boolean   year=		regexpressionmethod.year(seasonYear.toString());
		if(dcode && mcode && year) {

		List<RepLandDataDetails> landata = repLandDataDetailsRepo.getLandDet(Integer.parseInt(requestModel.getDcode()),
				Integer.parseInt(requestModel.getMcode()));
		System.out.println("details===================>" + landata.size());
		return landata;
	}
		return null;
	}
	// ---------------------------------- NonWebView---------------------------------------//
	@PostMapping("/nonwebv")
	public ResponseEntity<?> getNonWebV(@RequestBody RequestModel requestModel) {
		System.out.println("requestModel=>" + requestModel.toString());
		String[] season = requestModel.getCropyear().split("@");
		String cseason = season[0];
		Integer Year = Integer.parseInt(season[1]);

		RegularExpressionclassMethod regexpressionmethod = new RegularExpressionclassMethod();
		boolean dcode=	regexpressionmethod.districtCode(requestModel.getDcode());
		boolean mcode=	regexpressionmethod.mandalCode(requestModel.getMcode());
		boolean   year=		regexpressionmethod.year(Year.toString());
		if(dcode && mcode && year) {
		
		try {
			
			List<NonWebView> nonwebv = seasonCropBookedExtentRepo.getNonwebView(
					Integer.parseInt(requestModel.getDcode()), 
					Integer.parseInt(requestModel.getMcode()), 
					cseason,
					Year);
			System.out.println("crpins size=>" + nonwebv.size());
			return new ResponseEntity<List<NonWebView>>(nonwebv, HttpStatus.OK);
		} catch (Exception e) {

			System.out.println("Exception =>" + e);
			return null;
		}
		
		}
		return null;
		}
	// =====================CropwiseExtBookedRBKwise=======================//
	@Autowired
	CropwiseExtBookedRBKwisePartition cropwiseExtBookedRBKwisePartition;

	@PostMapping("/rbkext")
	public ResponseEntity<?> getRbkWise(@RequestBody RequestModel requestModel) {
		System.out.println("requestModel=>" + requestModel.toString());
		String[] season = requestModel.getCropyear().split("@");
		String seasonType = season[0];
		Integer seasonYear = Integer.parseInt(season[1]);
		
		RegularExpressionclassMethod regexpressionmethod = new RegularExpressionclassMethod();
		boolean dcode=	regexpressionmethod.districtCode(requestModel.getDcode());
		boolean mcode=	regexpressionmethod.mandalCode(requestModel.getMcode());
		boolean  year=	regexpressionmethod.year(seasonYear.toString());
		boolean  crop=	regexpressionmethod.cropCode(requestModel.getCrop());
		if(dcode && mcode && year&& crop) {

		try {
			
			

			List<CropwiseExtBookedRBKwise> rbkext = cropwiseExtBookedRBKwisePartition.getBkExtRbk(
					requestModel.getDcode(), 
					requestModel.getMcode(), 
					requestModel.getCrop(),
					requestModel.getCropyear());
			System.out.println("crpins size=>" + rbkext.size());
			return new ResponseEntity<List<CropwiseExtBookedRBKwise>>(rbkext, HttpStatus.OK);
		} catch (Exception e) {

			System.out.println("getStackTrace =>" + e.getStackTrace());
			return null;
		}
		}
		return null;
	}
	
	
	// =====================AuthMAOvaaVroEkyc=======================//
		@Autowired
		AuthMAOvaaVroEkycPartition authMAOvaaVroEkycPartition;

		@PostMapping("/authMaoVaaVroEkyc")
		public ResponseEntity<?> getAuthEkyc(@RequestBody RequestModel requestModel) {
			System.out.println("requestModel=>" + requestModel.toString());
			String[] season = requestModel.getCropyear().split("@");
			String cseason = season[0];
			Integer Year = Integer.parseInt(season[1]);
			
			try {

				RegularExpressionclassMethod regexpressionmethod = new RegularExpressionclassMethod();
				boolean mcode=	regexpressionmethod.mandalCode(requestModel.getMcode());
				boolean   saesonid=	regexpressionmethod.year(Year.toString());
				if(mcode && saesonid) {

				List<AuthMAOvaaVroEkyc> maoauth = authMAOvaaVroEkycPartition.getAuthMaoVaaVroEkyc(
						 requestModel.getMcode(),
						requestModel.getCropyear());
				System.out.println("crpins size=>" + maoauth.size());
				return new ResponseEntity<List<AuthMAOvaaVroEkyc>>(maoauth, HttpStatus.OK);
				}
				} catch (Exception e) {

				System.out.println("Exception =>" + e);
				
			}
			return null;
			}
		// =====================Superchekupdstatus=======================//
				@Autowired
				SuperchekupdstatusPartition superchekupdstatusPartition;

				@PostMapping("/supchkupdstatus")
				public ResponseEntity<?> getSupChkUpdSts(@RequestBody RequestModel requestModel) {
					System.out.println("requestModel=>" + requestModel.toString());
					String[] season = requestModel.getCropyear().split("@");
					String cseason = season[0];
					Integer Year = Integer.parseInt(season[1]);
					
					RegularExpressionclassMethod regexpressionmethod = new RegularExpressionclassMethod();
					boolean wbdcode=	regexpressionmethod.districtCode(requestModel.getWbdcode());
					boolean wbmcode=	regexpressionmethod.mandalCode(requestModel.getWbmcode());
					boolean   saesonid=		regexpressionmethod.year(Year.toString());
					if(wbdcode && wbmcode &&saesonid) {

					try {

						List<Superchekupdstatus> supupds = superchekupdstatusPartition.getSupChkUpdSts(
								 requestModel.getWbdcode(),
								 requestModel.getWbmcode(),
								requestModel.getCropyear());
						System.out.println("crpins size=>" + supupds.size());
						return new ResponseEntity<List<Superchekupdstatus>>(supupds, HttpStatus.OK);
					} catch (Exception e) {

						System.out.println("getStackTrace =>" + e.getStackTrace());
						return null;
					}
				}
					return null;
				}	
//===========================//MaoSocialAuditcorrectionRepo//================//
				@Autowired private MaoSocialAuditcorrectionRepo maoSocialAuditcorrectionRepo;
				
				@PostMapping("/maoSocialAudit")
				List<MaoSocialAuditcorrection> getSocialAuditCoorection(@RequestBody RequestModel requestModel) {
					System.out.println("requestModel=>" + requestModel.toString());
					
					String[] season = requestModel.getCropyear().split("@");
					String seasonType = season[0];
					Integer seasonYear = Integer.parseInt(season[1]);
					
					RegularExpressionclassMethod regexpressionmethod = new RegularExpressionclassMethod();
					boolean wbdcode=	regexpressionmethod.districtCode(requestModel.getDcode());
					boolean wbmcode=	regexpressionmethod.mandalCode(requestModel.getMcode());
					boolean   saesonid=		regexpressionmethod.year(seasonYear.toString());
					if(wbdcode && wbmcode &&saesonid) {
					
					List<MaoSocialAuditcorrection> socialaudit = maoSocialAuditcorrectionRepo.getSocialAudit(
							Integer.parseInt(requestModel.getDcode()),
							Integer.parseInt( requestModel.getMcode()),
							seasonYear,
							seasonType);
					
					System.out.println("list size=>" + socialaudit.size());
					System.out.println("list =>" + socialaudit.toString());
					return socialaudit;
				}
					return null;
				
				}	
				//===========================//Rep_Suprcheck_Vill//================//
				@Autowired private SupercheckVillRepo supercheckVillRepo;
				
				@PostMapping("/supvill")
				List<SupercheckVill> getSupchkVill(@RequestBody RequestModel requestModel) {
					System.out.println("requestModel=>" + requestModel.toString());
					RegularExpressionclassMethod regexpressionmethod = new RegularExpressionclassMethod();
					boolean wbdcode=	regexpressionmethod.districtCode(requestModel.getWbdcode());
					boolean wbmcode=	regexpressionmethod.mandalCode(requestModel.getWbmcode());
					
					if(wbdcode && wbmcode) {

				
					List<SupercheckVill> supvil = supercheckVillRepo.getSupVill(
							requestModel.getWbdcode(),
						     requestModel.getWbmcode());
					System.out.println("list size=>" + supvil.size());
					System.out.println("list =>" + supvil.toString());
					return supvil;
				}
					return null;
}	
					//===========================//Rep_cropIns_abtract//================//
				//@Autowired private CropInsAbstractRepo cropInsAbstractRepo;
				
				@PostMapping("/cropinsab")
				List<CropInsAbstractt> getCropInsAbstract(@RequestBody RequestModel requestModel) {
					System.out.println("requestModel=>" + requestModel.toString());

					
						List<CropInsAbstractt> cropinsab = seasonCropBookedExtentRepo.getCropInss(
								Integer.parseInt(requestModel.getDcode()));
						System.out.println("list size=>" + cropinsab.size());
						//System.out.println("list =>" + cropinsab.toString());
						return cropinsab;
					
					
				}
				
				//===========================//Rep_Pernnial_Mand//================//
				@Autowired private RepPernnialMandPartition repPernnialMandPartition;
				
				@PostMapping("/pernnialMand")
				List<RepPernnialMand> getPernnialMand(@RequestBody RequestModel requestModel) {
					System.out.println("requestModel=>" + requestModel.toString());
					String[] season = requestModel.getCropyear().split("@");
					String seasonType = season[0];
					Integer seasonYear = Integer.parseInt(season[1]);
					
					RegularExpressionclassMethod regexpressionmethod = new RegularExpressionclassMethod();
					boolean dcode=	regexpressionmethod.districtCode(requestModel.getDcode());
					boolean wbmcode=	regexpressionmethod.mandalCode(requestModel.getWbmcode());
					boolean vcode=	regexpressionmethod.villageCode(requestModel.getVcode());
					boolean mcode=	regexpressionmethod.mandalCode(requestModel.getMcode());
					boolean wbmcodee=	regexpressionmethod.mandalCode(requestModel.getWbmcode());
					boolean   saesonid=	regexpressionmethod.year(seasonYear.toString());
					if(dcode&&wbmcode&&vcode &&mcode&& wbmcodee&&saesonid) {

					
					List<RepPernnialMand> pernnial = repPernnialMandPartition.getPerrnniaDet(
							requestModel.getDcode(),
							requestModel.getWbmcode(),
							requestModel.getVcode(),
							requestModel.getCropyear(),
							requestModel.getWbdcode());
					System.out.println("list size=>" + pernnial.size());
					System.out.println("list =>" + pernnial.toString());
					return pernnial;
				}
					return null;
					}
}
