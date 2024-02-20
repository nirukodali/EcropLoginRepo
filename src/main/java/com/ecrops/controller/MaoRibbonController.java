package com.ecrops.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecrops.entity.CropBookingDetailsMaoIntf;
import com.ecrops.entity.RepPernnialMand;
import com.ecrops.model.PerinalReportModel;
import com.ecrops.model.RequestModel;
import com.ecrops.partitions.CropBookingDetailsMaoIntfPartition;
import com.ecrops.partitions.RepPernnialMandPartition;
import com.ecrops.repo.ActiveSeasonRepository;
import com.ecrops.repo.FarmerBookingDetailsPartitions;
import com.ecrops.repo.FarmerBookingDetailsRepo;
import com.ecrops.repo.NormalAreasMwiseMaoRepo;
import com.ecrops.repo.RepLandDataDetailsRepo;
import com.ecrops.repo.RepLandDataDetailsRepo.Rep_VillLandDataDetails;

@Controller
public class MaoRibbonController {

	@Autowired
	RepLandDataDetailsRepo repLandDataDetailsRepo;
	@Autowired
	FarmerBookingDetailsRepo farmerBookingDetailsRepo;
	@Autowired
	FarmerBookingDetailsPartitions partion;
	@Autowired
	ActiveSeasonRepository activerepo;
	@Autowired
	private RepPernnialMandPartition repPernnialMandPartition;

	@GetMapping("/normal")
	public String getNormalAreaList(HttpSession httpSession, Model model) {
		String dcode = (String) httpSession.getAttribute("dcode");
		String mcode = (String) httpSession.getAttribute("mcode");

		System.out.println("dcode===================" + dcode);
		System.out.println("mcode==============" + mcode);
		model.addAttribute("dcode", "dcode");
		model.addAttribute("mcode", "mcode");
		return "normalareasmao";
	}

	@GetMapping("/crop")
	public String getCropDetails(Model model) {
//	model.addAttribute("crp",crp);
		return "cropBookingDetailsMAO";
	}

	@GetMapping("/farmerdetails")
	public String getFarmerDetails(HttpSession httpSession) {
		return "farmerbookingDetails";
	}

	@GetMapping("/rofr")
	public String roftbkdext(Model model) {
		return "rofr-extentbooked";
	}

	@GetMapping("/ekycmao")
	public String MaoEkyc(Model model) {
		return "maovaaVroEkyc";
	}

	@GetMapping("/rbksnomapping")
	public String rSnoMap() {
		return "RbkSurveyNoMapping";
	}

	@GetMapping("/allocatedSnoMap")
	public String allSnoMap(Model model) {
		return "Allocated_SurveyNo_Mapping";
	}

	@GetMapping("/datasrc")
	public String getDataSrc(Model model) {
		return "DataSourceWiseExt";

	}

	@GetMapping("/efishRofr")
	public String getEfishRofr(Model model) {
		return "EfishRofrDetails";

	}

	@GetMapping("/farmdet")
	public String getFarmerDet(Model model) {
		return "FarmerDetails";

	}

	@GetMapping("/allcrops")
	public String getSeasonAllCrops(Model model) {
		return "SeasonCropBookedExtent";

	}

	@GetMapping("/efblkext")
	public String getBlockedEfishExt(Model model) {
		return "BlockedEfishExtent";
	}

	@GetMapping("/objunobj")
	public String getObjUnObj(Model model) {
		return "obj_unObj";
	}

	@GetMapping("/empL")
	public String getRepEmpList(Model model) {
		return "EmployeeList";
	}

	@GetMapping("/repvaadet")
	public String getRepVAADet(Model model) {
		return "VaaDetails";
	}

	@GetMapping("/devregdett")
	public String getDevRegDet(Model model) {
		return "DeviceRegDetails";
	}

	@GetMapping("/cropins")
	public String getCropInsGri(Model model) {
		return "CropInsGrivence";
	}

	@GetMapping("/supchkra")
	public String getSupChkRecrdAlloted(Model model) {
		return "SuperCheckRecordsAlloted";
	}

	@GetMapping("/supchkappr")
	public String getSupChkAppr(Model model) {
		return "SpuperChkAppr";

	}

	@GetMapping("/supchk")
	public String getSupChR(Model model) {
		return "SpuperCheck";

	}

	@GetMapping("/supchkrejreport")
	public String getSupChRej(Model model) {
		return "SuperChk_rejReport";

	}
//======================CropBookingDetailsMaoIntf===========================//
	@Autowired CropBookingDetailsMaoIntfPartition cropBookingDetailsMaoIntfPartition;
	
	@GetMapping("/cropbmao")
	public String getcrpMao(Model model, HttpSession session) {
		String wbemname = (String)session.getAttribute("wbemname");
		String wbevname = (String)session.getAttribute("wbevname");
		
		System.out.println("wbemname=>"+wbemname);
		System.out.println("wbevname=>"+wbevname);
		
		return "CropBookingDetailsMaoIntf";

	}

	@GetMapping("/phyackvwise")
	public String getPhyAckVwise(Model model) {
		return "PhyAckVwise";

	}

	@GetMapping("/phyackrbk")
	public String getPhyAckRbk(Model model) {
		return "Rep_phy_ack_rbk";

	}

	@GetMapping("/dwnlddetintf")
	public String getDwnldDetIntf(Model model) {
		return "Rep_DownloadedDetailsIntf";

	}

	@GetMapping("/landdatadet")
	public String getLandData() {

		return "RepLandDataDetails";

	}// repLandDataDetailsRepo

	@RequestMapping("/villLandData")
	public String getVillLandData(HttpServletRequest httpServletRequest, Model model) {
		System.out.println("villLandData");
		String dcode = httpServletRequest.getParameter("dcode");
		String mcode = httpServletRequest.getParameter("mcode");
		
		
		List<Rep_VillLandDataDetails> list = repLandDataDetailsRepo.getVillData(Integer.parseInt(dcode),
				Integer.parseInt(mcode));
		model.addAttribute("data", list);
		return "Rep_VillLandDataDetails";
	}

	@GetMapping("/nonwebview")
	public String getNonwebV(Model model) {
		return "nonWebView";
	}

	@GetMapping("/crpwrbkext")
	public String getcrpWiseRbkExt(Model model, HttpServletRequest httpServletRequest) {
		return "CropwiseExtBooked_RBKwise";
	}

	@GetMapping("/authmaoekycvaavaro")
	public String getAuthMaoEkyc() {
		return "Auth_MAO_vaavroekyc";
	}

	@GetMapping("/supupdsts")
	public String getSupUpdsts() {
		return "Superchekupdstatus";
	}

	@GetMapping("/maosocialauditR")
	public String getMaoSocialAuditCorrectionR() {
		return "MaoSocialAuditcorrection";
	}

	@GetMapping("/repsupchkvill")
	public String getSupCheckVill(Model model) {
		return "Rep_supchk_vill";
	}

	@GetMapping("/cropinsabs")
	public String getCropInsAbs(Model model) {
		return "Rep_cropIns_abtract";
	}

	@GetMapping("/pernnialmand")
	public String getPernnialMand(Model model) {
		return "Rep_Pernnial_Mand";
	}

	@GetMapping("/pernnialMand")
	public String pernnialMand(Model model, HttpServletRequest httpServletRequest,HttpSession session) {

		String dcodee = httpServletRequest.getParameter("dcodee");
		String inputwbmcode = httpServletRequest.getParameter("inputwbmcode");
		String vcode = httpServletRequest.getParameter("vcode");
		String cropyear = httpServletRequest.getParameter("cropyear");
		String inputwbdcode = httpServletRequest.getParameter("inputwbdcode");

		String cropid = httpServletRequest.getParameter("cropid");

		System.out.println("cropyear=>" + cropyear);
		System.out.println("vcode=>" + vcode);
		System.out.println("cropid=>" + cropid);
		System.out.println("inputwbdcode=>" + inputwbdcode);

		List<RepPernnialMand> pernnial = repPernnialMandPartition.getPerrnniaDet(dcodee, inputwbmcode, vcode, cropyear, inputwbdcode);
		System.out.println("list size=>" + pernnial.size());
		
		String wbemname = (String)session.getAttribute("wbemname");
		String wbevname = (String)session.getAttribute("wbevname");
		
		System.out.println("wbemname=>"+wbemname);
		System.out.println("wbevname=>"+wbevname);
		
		Integer count = 0;
		String powner_tenant = "", tsno = "";
		String tkhno = "";
		List<PerinalReportModel> list = new ArrayList<>();
		
		for(RepPernnialMand bean: pernnial) {
			PerinalReportModel entity = new PerinalReportModel();
			
				count = count + 1;
				entity.setCount(count);
				entity.setWbemname(wbemname);
				entity.setWbevname(wbevname);
				
				entity.setOc_name(bean.getOc_name());
				entity.setOc_fname(bean.getOc_fname());
				
				powner_tenant = bean.getOwner_tenant();
				if (powner_tenant.equals("O")) {
	                powner_tenant = "Pattadar";
	            } else {
	                powner_tenant = "Cultivator";
	            }
				entity.setOwner_tenant(powner_tenant);
				
				entity.setKh_no(bean.getKh_no());
				entity.setCr_sno(bean.getCr_sno());
				entity.setCropname(bean.getCropname());
				
				entity.setCr_mix_unmix_ext(bean.getCr_mix_unmix_ext());
				entity.setAge(bean.getAge());
				entity.setMobileno(bean.getMobileno());
			 
			
			list.add(entity);
		}
		
		model.addAttribute("list", list);

		return "Rep_Pernnial_Mand";
	}

}
