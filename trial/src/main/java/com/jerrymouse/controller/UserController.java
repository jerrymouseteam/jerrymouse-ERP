package com.jerrymouse.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jerrymouse.dao.UserDAO;
import com.jerrymouse.entity.ChallanDetails;
import com.jerrymouse.entity.EmpDetails;
import com.jerrymouse.entity.EmpLogin;
import com.jerrymouse.entity.EmployeeProjectJoin;
import com.jerrymouse.entity.ItemList;
import com.jerrymouse.entity.ItemListId;
import com.jerrymouse.entity.MatRequi;
import com.jerrymouse.entity.Project;
import com.jerrymouse.entity.PurOrder;
import com.jerrymouse.entity.RequiPur;
import com.jerrymouse.util.GradeType;
import com.jerrymouse.util.MaterialType;
import com.jerrymouse.util.ReqStatus;
import com.jerrymouse.util.RoleType;
import com.jerrymouse.util.SendMail;
import com.jerrymouse.util.UnitType;
import com.jerrymouse.util.UserRoles;
import com.jerrymouse.vo.ChallanViewVo;
import com.jerrymouse.vo.EmpDetailsVo;
import com.jerrymouse.vo.MaterialObjectVo;
import com.jerrymouse.vo.PoViewVo;
import com.jerrymouse.vo.RequisitionViewVo;
import com.jerrymouse.vo.SearchUserVo;

@Controller
public class UserController {

	@Autowired
	@Qualifier("userDaoImpl")
	private UserDAO userDao;

	@RequestMapping("/login")
	@ResponseBody
	@Transactional
	public String login(HttpServletRequest request, HttpServletResponse res) {
		String loginStatus = null;
		try {
			System.out.println("I an happy to be here");
			System.out.println(request.getParameter("txt_username"));
			EmpLogin empLogin = userDao.find(request
					.getParameter("txt_username"));
			System.out.println(empLogin);
			if (empLogin != null) {
				if (empLogin.getPassword().equals(
						request.getParameter("txt_password"))) {
					HttpSession session = request.getSession();
					session.setAttribute("USERNAME",
							request.getParameter("txt_username"));

					loginStatus = "Valid Login";
				} else {
					loginStatus = "Invalid Login";
				}
			} else {
				loginStatus = "Not registered";
			}
			System.out.println("login status : " + loginStatus);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loginStatus;
	}

	@RequestMapping("/loginPage")
	@Transactional
	public ModelAndView loginPage(HttpServletRequest request,
			HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("login");
		return mv;
	}

	@RequestMapping("/materialReqPage")
	@Transactional
	public ModelAndView materialReqPage(HttpServletRequest request,
			HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("materialType", Arrays.asList(MaterialType.values()));
		mv.addObject("dateType", new Date());
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("USERNAME");
		if (userName != null) {
			EmpLogin empLogin = userDao.find(userName);
			Set<String> projectName = new HashSet<String>(0);
			Set<String> projectSectName = new HashSet<String>(0);
			for (EmployeeProjectJoin projectJoin : empLogin.getEmpDetails()
					.getEmployeeProjectJoins()) {
				if (projectJoin.getProject() != null) {
					projectName.add(projectJoin.getProject().getProjNm());
					projectSectName.add(projectJoin.getProject().getProjSect());
				}
			}
			mv.addObject("projectName", projectName);
			mv.addObject("projSectName", projectSectName);
			mv.addObject("reqno", userDao.getSequenceValue("requisition_seq"));
		}
		mv.setViewName("materialRequisition");
		return mv;
	}

	@RequestMapping("/decideUserAccordingToRole")
	@Transactional
	public ModelAndView decideUserPageAccordingToRole(
			HttpServletRequest request, HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("USERNAME");
		if (userName != null) {
			EmpLogin empLogin = userDao.find(userName);
			EmpDetails empDetails = empLogin.getEmpDetails();
			if (empDetails.getEmpRole() != null) {

				String empRole = empDetails.getEmpRole();
				if (RoleType.Admin.getRoleType().equalsIgnoreCase(empRole)) {
					mv.addObject("name",
							empDetails.getFirstNm() + empDetails.getLastNm());
					mv.setViewName("admin_profile");
				} else if (RoleType.Storekeeper.getRoleType().equalsIgnoreCase(
						empRole)) {
					mv.addObject("name",
							empDetails.getFirstNm() + empDetails.getLastNm());
					mv.setViewName("labtech_storekeeper_profile");
				} else if (RoleType.Sector_Engineer.getRoleType()
						.equalsIgnoreCase(empRole)) {
					mv.addObject("name",
							empDetails.getFirstNm() + empDetails.getLastNm());
					mv.setViewName("sect_engg_profile");
				} else if (RoleType.SITE_ENGG_PROFILE.getRoleType()
						.equalsIgnoreCase(empRole)) {
					mv.addObject("name",
							empDetails.getFirstNm() + empDetails.getLastNm());
					mv.setViewName("site_engg_profile");
				} else if (RoleType.Purchase.getRoleType().equalsIgnoreCase(
						empRole)) {
					mv.addObject("name",
							empDetails.getFirstNm() + empDetails.getLastNm());
					mv.setViewName("pur_dept_profile");
				} else if (RoleType.LAB_TECHNICIAN.getRoleType()
						.equalsIgnoreCase(empRole)) {
					mv.addObject("name",
							empDetails.getFirstNm() + empDetails.getLastNm());
					mv.setViewName("labtech_storekeeper_profile");
				}
			}

		}
		// mv.setViewName("materialRequisition");
		return mv;
	}

	@RequestMapping("/sendEmail")
	@ResponseBody
	@Transactional
	public boolean sendEmail(HttpServletRequest request, HttpServletResponse res) {
		boolean emailSentStatus = false;
		System.out.println((String) request.getParameter("email"));
		String emailId = (String) request.getParameter("email");
		if (emailId != null) {
			System.out.println(emailId);
			EmpLogin empLogin = userDao.findUsingEmpEmail(emailId);
			System.out.println("did you find : " + empLogin);
			if (empLogin != null) {
				String newPassword = "newPassword1";
				emailSentStatus = SendMail.sendMail(emailId, newPassword);
				if (emailSentStatus) {
					empLogin.setPassword(newPassword);
					userDao.update(empLogin);
				}
			}
		}
		return emailSentStatus;
	}

	@RequestMapping("/changePasswordPage")
	@ResponseBody
	@Transactional
	public ModelAndView changePasswordPage(HttpServletRequest request,
			HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("change_password");
		return mv;
	}

	@RequestMapping("/changePassword")
	@ResponseBody
	@Transactional
	public int changePassword(HttpServletRequest request,
			HttpServletResponse res) {
		int passwordValue = -1;

		EmpLogin empLogin = userDao.find(request.getParameter("txt_username"));
		System.out.println(empLogin);
		if (empLogin != null) {
			if (empLogin.getPassword().equals(
					request.getParameter("txt_oldpwd"))) {

				empLogin.setPassword(request.getParameter("txt_newpwd"));
				userDao.update(empLogin);
				passwordValue = 1;

			} else {
				passwordValue = 0;
			}
		}

		return passwordValue;
	}

	@RequestMapping("/updateEmployeeWithProjectAssign")
	@ResponseBody
	@Transactional
	public String updateEmployeeWithProjectAssign(HttpServletRequest request,
			HttpServletResponse res) {
		String updateEmployeeWithProject = "invalid entry";

		System.out.println((String) request.getParameter("txt_uname"));
		System.out.println((String) request.getParameter("txt_proj_sec"));

		String userName = (String) request.getParameter("txt_uname");
		String projectName = (String) request.getParameter("txt_proj_sec");

		String[] splitProjectName = projectName.split("-");

		EmpLogin empLogin = userDao.find(userName);
		Project project = userDao.getProject(splitProjectName[0],
				splitProjectName[1]);

		if (empLogin != null && project != null) {

			/**
			 * If the project is already assigned to the user.
			 */
			for (EmployeeProjectJoin employeeProjectJoin : empLogin
					.getEmpDetails().getEmployeeProjectJoins()) {
				if (project.getProjectId().intValue() == employeeProjectJoin
						.getProject().getProjectId().intValue()) {
					return "Project already exists";
				}

			}

			/**
			 * add the project to the given user.
			 */
			EmployeeProjectJoin projectJoin = new EmployeeProjectJoin(
					empLogin.getEmpDetails(), project);
			projectJoin.setId(userDao.getSequenceValue("employee_join_seq"));

			empLogin.getEmpDetails().getEmployeeProjectJoins().add(projectJoin);
			projectJoin.setEmpDetails(empLogin.getEmpDetails());
			projectJoin.setProject(project);
			userDao.update(empLogin);

			updateEmployeeWithProject = "project assigned";
		}

		return updateEmployeeWithProject;
	}

	@RequestMapping("/addProject")
	@ResponseBody
	@Transactional
	public boolean addProject(HttpServletRequest request,
			HttpServletResponse res) {

		boolean isProjectAdded = false;
		System.out.println((String) request.getParameter("txt_proj_name"));
		System.out.println((String) request.getParameter("txt_proj_sec"));

		String projectName = (String) request.getParameter("txt_proj_name");
		String projectSectName = (String) request.getParameter("txt_proj_sec");
		String delAddr = (String) request.getParameter("del_addr");

		Project projectAlreadyExists = null;
		try {
			projectAlreadyExists = userDao.getProject(projectName,
					projectSectName);
		} catch (NoResultException noResult) {
			System.out.println("This is checked and perfectly fine.");
		}
		/**
		 * In case project with same project name and sector exists then user
		 * get an error saying project already exists and hence no duplicate
		 * project should exists.
		 */
		if (projectAlreadyExists == null) {
			Project project = new Project();
			project.setProjNm(projectName);
			project.setProjSect(projectSectName);
			project.setDelAddr(delAddr);
			userDao.addProject(project);
			isProjectAdded = true;
		}

		return isProjectAdded;
	}

	@RequestMapping("/deleteEmployee")
	@Transactional
	@ResponseBody
	public int deleteEmployeeFromDatabase(HttpServletRequest request,
			HttpServletResponse res) {
		/**
		 * If error is found then send the default value.
		 */
		int employeeDeleteValue = -1;

		System.out.println(request.getParameter("rb_emp"));
		EmpLogin empLogin = userDao.find(request.getParameter("rb_emp"));

		if (empLogin != null) {
			userDao.deleteEmployee(empLogin);
			/**
			 * employee is successfully deleted;
			 */
			employeeDeleteValue = 1;

		} else {
			/**
			 * In case the user is not found in db.
			 */
			employeeDeleteValue = 2;
		}
		return employeeDeleteValue;
	}

	@RequestMapping("/updateEmployeeWithProjectUnassign")
	@ResponseBody
	@Transactional
	public boolean updateEmployeeWithProjectUnassign(
			HttpServletRequest request, HttpServletResponse res) {
		boolean updateEmployeeWithProjectUnassign = false;

		System.out.println((String) request.getParameter("txt_uname"));
		System.out.println((String) request.getParameter("txt_proj_sec"));

		String userName = (String) request.getParameter("txt_uname");
		String projectName = (String) request.getParameter("txt_proj_sec");

		String[] splitProjectName = projectName.split("-");

		EmpLogin empLogin = userDao.find(userName);

		Project project = userDao.getProject(splitProjectName[0],
				splitProjectName[1]);

		if (empLogin != null) {
			System.out.println("lets unassign the project");
			EmployeeProjectJoin employeeProjectJoinThathasToBeRemoved = null;

			for (EmployeeProjectJoin employeeProjectJoin : empLogin
					.getEmpDetails().getEmployeeProjectJoins()) {
				if (employeeProjectJoin.getProject().getProjNm()
						.equalsIgnoreCase(project.getProjNm())
						&& employeeProjectJoin.getProject().getProjSect()
								.equalsIgnoreCase(project.getProjSect())) {
					employeeProjectJoinThathasToBeRemoved = employeeProjectJoin;
				}
			}

			System.out.println(employeeProjectJoinThathasToBeRemoved
					+ "remove this");

			empLogin.getEmpDetails().getEmployeeProjectJoins()
					.remove(employeeProjectJoinThathasToBeRemoved);
			employeeProjectJoinThathasToBeRemoved.setEmpDetails(null);

			/**
			 * unassign the project from the given user.
			 */
			userDao.update(empLogin);

			project.getEmployeeProjectJoins().remove(
					employeeProjectJoinThathasToBeRemoved);
			employeeProjectJoinThathasToBeRemoved.setProject(null);
			userDao.updateProject(project);

			userDao.removeEmployeeProjectJoin(employeeProjectJoinThathasToBeRemoved);

			updateEmployeeWithProjectUnassign = true;
		}

		return updateEmployeeWithProjectUnassign;
	}

	@RequestMapping("/userIdValidate")
	@ResponseBody
	@Transactional
	public String userIdValidation(HttpServletRequest request,
			HttpServletResponse res) {
		String userIdStatus = null;
		try {
			EmpLogin empLogin = userDao.find(request.getParameter("username"));
			if (empLogin != null) {
				userIdStatus = "Entry Exists!!";
			} else {
				userIdStatus = "Entry Does not exist!!";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userIdStatus;
	}

	@RequestMapping("/projAssign")
	@Transactional
	public ModelAndView projectAssign(HttpServletRequest request,
			HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		List<String> projectName = new ArrayList<String>();

		for (Project project : userDao.getProjectList()) {
			projectName.add(project.getProjNm() + "-" + project.getProjSect());
		}
		modelAndView.addObject("projectName", projectName);
		modelAndView.setViewName("proj_assign");
		return modelAndView;
	}

	@RequestMapping("/projUnassign")
	@Transactional
	public ModelAndView projectUnassign(HttpServletRequest request,
			HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("proj_unassign");
		return modelAndView;
	}

	@RequestMapping("/projectsAssignedToTheUser")
	@ResponseBody
	@Transactional
	public List<String> projectsAssignedToTheUser(HttpServletRequest request,
			HttpServletResponse res) {
		System.out.println("hi i am here");
		List<String> projectlistAssinedToTheUser = new ArrayList<String>();

		System.out.println(request.getParameter("username") + "ss");
		EmpLogin empLogin = userDao.find(request.getParameter("username"));
		if (empLogin != null) {
			projectlistAssinedToTheUser.add("-Please Select-");
			for (EmployeeProjectJoin employeeProjectJoin : empLogin
					.getEmpDetails().getEmployeeProjectJoins()) {
				if (employeeProjectJoin.getProject() != null) {
					System.out.println("Hi"
							+ employeeProjectJoin.getProject().getProjNm()
							+ "-"
							+ employeeProjectJoin.getProject().getProjSect());
					projectlistAssinedToTheUser.add(employeeProjectJoin
							.getProject().getProjNm()
							+ "-"
							+ employeeProjectJoin.getProject().getProjSect());
				}
			}
		}

		System.out.println("hi i am here part 2" + projectlistAssinedToTheUser);
		return projectlistAssinedToTheUser;
	}

	@RequestMapping("/empRegisteration")
	@Transactional
	public ModelAndView employeeRegisteration(HttpServletRequest request,
			HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("emp_registration");
		return modelAndView;
	}

	@RequestMapping("/empUpdate")
	@Transactional
	public ModelAndView employeeUpdate(HttpServletRequest request,
			HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("emp_update");
		return modelAndView;
	}

	@RequestMapping("/empDelete")
	@Transactional
	public ModelAndView employeeDelete(HttpServletRequest request,
			HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("hi project assign");
		modelAndView.setViewName("emp_delete");
		return modelAndView;
	}

	@RequestMapping("/projAdd")
	@Transactional
	public ModelAndView projectAdd(HttpServletRequest request,
			HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("hi project assign");
		modelAndView.setViewName("proj_add");
		return modelAndView;
	}

	@RequestMapping("/register")
	@Transactional
	public ModelAndView registerPage(HttpServletRequest request,
			HttpServletResponse res) {

		ModelAndView mv = new ModelAndView();
		mv.addObject("content", Arrays.asList(UserRoles.values()));
		mv.setViewName("newUser");
		return mv;
	}

	@RequestMapping("/helloWorld")
	@Transactional
	public ModelAndView helloWorld(HttpServletRequest request,
			HttpServletResponse res) {

		ModelAndView mv = new ModelAndView();
		HttpSession session = request.getSession();
		mv.addObject("name", session.getAttribute("USERNAME"));
		return mv;
	}

	@RequestMapping("/registerEmployee")
	@Transactional
	@ResponseBody
	public int registerEmployee(HttpServletRequest request,
			HttpServletResponse res) {

		int status = 0;
		EmpLogin empLogin = new EmpLogin();
		empLogin.setUserNm(request.getParameter("txtusername"));
		empLogin.setPassword(request.getParameter("txtpassword"));

		EmpDetails empDetails = new EmpDetails();
		empDetails.setFirstNm(request.getParameter("txtfname"));
		empDetails.setLastNm(request.getParameter("txtlname"));
		empDetails.setMidNm(request.getParameter("txtmname"));
		empDetails.setEmpEmail(request.getParameter("txtemail"));
		empDetails.setEmpRole(request.getParameter("ddl_role"));

		empDetails.setEmpAddr(request.getParameter("taaddress"));
		empDetails.setEmpTel1(request.getParameter("txtmobile"));
		empDetails.setEmpTel2(request.getParameter("txtaltnum"));
		empDetails.setUserNm(request.getParameter("txtusername"));
		empDetails.setEmpLogin(empLogin);

		empLogin.setEmpDetails(empDetails);

		if (userDao.findEmployeeByEmailId(request.getParameter("txtemail")) != null) {
			status = 2;
		} else if (userDao.find(request.getParameter("txtusername")) != null) {
			status = 3;
		} else {
			userDao.persist(empLogin);
			status = 1;
		}
		return status;
	}

	@RequestMapping("/addRequisitionForm")
	@Transactional
	public @ResponseBody
	boolean addRequisitionForm(HttpServletRequest request,
			HttpServletResponse res) throws ParseException {

		boolean requisitionAdded = false;
		DateFormat dateFormatdd = new SimpleDateFormat("dd-mm-yyyy");
		DateFormat dateFormatyyyy = new SimpleDateFormat("yyyy-mm-dd");

		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("USERNAME");
		System.out.println("jksdhf");
		if (userName != null) {
			EmpLogin empLogin = userDao.find(userName);
			MatRequi matRequi = new MatRequi();
			matRequi.setAuthorizeSectEngg(false);

			matRequi.setJustification(request.getParameter("tajustification"));
			matRequi.setReqNo(Long.valueOf(request.getParameter("txt_reqno")));
			matRequi.setRequestedBy(request.getParameter("txtreqby"));
			matRequi.setReqSts(ReqStatus.req_raised.getReqStatus());
			System.out.println("generation date : "
					+ request.getParameter("txt_gdate"));
			matRequi.setDateGen(dateFormatdd.parse(request
					.getParameter("txt_gdate")));
			System.out.println("expected date : "
					+ request.getParameter("txt_expdate"));
			matRequi.setExpectedDt(dateFormatyyyy.parse(request
					.getParameter("txt_expdate")));

			Set<ItemList> itemListSet = new HashSet<ItemList>();
			int itemCount = 0;
			long itemId = new Long(request.getParameter("txt_reqno"));

			System.out.println("Also here");
			ItemList item1 = new ItemList();
			ItemListId item1id = new ItemListId(++itemCount, itemId);
			item1.setId(item1id);
			item1.setItemQty(Double.valueOf(request.getParameter("txtquantity")));
			item1.setUnit(request.getParameter("ddlunit"));
			item1.setUsedFor(request.getParameter("txtusedfor"));
			if (!(GradeType.N_A.getGradeType().equalsIgnoreCase(request
					.getParameter("ddlgrade")))) {
				item1.setItemGrd(request.getParameter("ddlgrade"));
			}
			item1.setItem(request.getParameter("ddlitem"));
			item1.setMatRequi(matRequi);
			itemListSet.add(item1);

			matRequi.setItemLists(itemListSet);

			for (EmployeeProjectJoin projectJoin : empLogin.getEmpDetails()
					.getEmployeeProjectJoins()) {
				String projectName = request.getParameter("ddlprojname");
				if (projectName != null && !projectName.isEmpty()) {
					String[] splitProjectName = projectName.split("-");
					if (splitProjectName.length > 1
							&& splitProjectName[0].equalsIgnoreCase(projectJoin
									.getProject().getProjNm())
							&& splitProjectName[1].equalsIgnoreCase(projectJoin
									.getProject().getProjSect())) {
						System.out.println("Inside here");
						matRequi.setProject(projectJoin.getProject());
						projectJoin.getProject().getMatRequis().add(matRequi);
						requisitionAdded = true;
					}
				}
			}

			System.out
					.println("project size :"
							+ empLogin.getEmpDetails()
									.getEmployeeProjectJoins().size());
			userDao.update(empLogin);
		}
		return requisitionAdded;
	}

	@RequestMapping("/dynamicMaterialValues")
	@Transactional
	public @ResponseBody
	MaterialObjectVo dynamicMaterialValues(HttpServletRequest request,
			HttpServletResponse res) throws Exception {
		MaterialObjectVo materialObjectVo = new MaterialObjectVo();
		List<String> gradeTypeList = new ArrayList<String>();
		List<String> unitTypeList = new ArrayList<String>();
		System.out.println("dg" + request.getParameter("materialType"));

		final String materialType = request.getParameter("materialType");

		if (MaterialType.Aggregates.getMaterialType().equalsIgnoreCase(
				materialType)) {
			gradeTypeList.add(GradeType.M1.getGradeType());
			gradeTypeList.add(GradeType.M2.getGradeType());
			unitTypeList.add(UnitType.brass.getUnitType());

		} else if (MaterialType.Blocks.getMaterialType().equalsIgnoreCase(
				materialType)) {
			gradeTypeList.add(GradeType.inch4.getGradeType());
			gradeTypeList.add(GradeType.inch6.getGradeType());
			gradeTypeList.add(GradeType.inch9.getGradeType());
			unitTypeList.add(UnitType.nos.getUnitType());

		} else if (MaterialType.Cement.getMaterialType().equalsIgnoreCase(
				materialType)) {
			gradeTypeList.add(GradeType.PPC.getGradeType());
			gradeTypeList.add(GradeType.OPC33.getGradeType());
			gradeTypeList.add(GradeType.OPC43.getGradeType());
			gradeTypeList.add(GradeType.OPC53.getGradeType());
			unitTypeList.add(UnitType.bags.getUnitType());

		} else if (MaterialType.ConventionalShuttering.getMaterialType()
				.equalsIgnoreCase(materialType)) {
			gradeTypeList.add(GradeType.N_A.getGradeType());
			unitTypeList.add(UnitType.sqm.getUnitType());

		} else if (MaterialType.MivanShuttering.getMaterialType()
				.equalsIgnoreCase(materialType)) {
			gradeTypeList.add(GradeType.N_A.getGradeType());
			unitTypeList.add(UnitType.sqm.getUnitType());

		} else if (MaterialType.RMC.getMaterialType().equalsIgnoreCase(
				materialType)) {
			gradeTypeList.add(GradeType.M20.getGradeType());
			gradeTypeList.add(GradeType.M25.getGradeType());
			gradeTypeList.add(GradeType.M30.getGradeType());
			gradeTypeList.add(GradeType.M35.getGradeType());
			gradeTypeList.add(GradeType.M40.getGradeType());
			gradeTypeList.add(GradeType.M45.getGradeType());
			gradeTypeList.add(GradeType.M50.getGradeType());
			unitTypeList.add(UnitType.cum.getUnitType());

		} else if (MaterialType.Sand.getMaterialType().equalsIgnoreCase(
				materialType)) {
			gradeTypeList.add(GradeType.N_A.getGradeType());
			unitTypeList.add(UnitType.brass.getUnitType());

		} else if (MaterialType.Steel.getMaterialType().equalsIgnoreCase(
				materialType)) {

			gradeTypeList.add(GradeType.FE415.getGradeType() + " "
					+ GradeType.d6mm.getGradeType());
			gradeTypeList.add(GradeType.FE415.getGradeType() + " "
					+ GradeType.d8mm.getGradeType());
			gradeTypeList.add(GradeType.FE415.getGradeType() + " "
					+ GradeType.d12mm.getGradeType());
			gradeTypeList.add(GradeType.FE415.getGradeType() + " "
					+ GradeType.d16mm.getGradeType());
			gradeTypeList.add(GradeType.FE415.getGradeType() + " "
					+ GradeType.d20mm.getGradeType());
			gradeTypeList.add(GradeType.FE415.getGradeType() + " "
					+ GradeType.d25mm.getGradeType());
			gradeTypeList.add(GradeType.FE415.getGradeType() + " "
					+ GradeType.d30mm.getGradeType());

			gradeTypeList.add(GradeType.FE500.getGradeType() + " "
					+ GradeType.d6mm.getGradeType());
			gradeTypeList.add(GradeType.FE500.getGradeType() + " "
					+ GradeType.d8mm.getGradeType());
			gradeTypeList.add(GradeType.FE500.getGradeType() + " "
					+ GradeType.d12mm.getGradeType());
			gradeTypeList.add(GradeType.FE500.getGradeType() + " "
					+ GradeType.d16mm.getGradeType());
			gradeTypeList.add(GradeType.FE500.getGradeType() + " "
					+ GradeType.d20mm.getGradeType());
			gradeTypeList.add(GradeType.FE500.getGradeType() + " "
					+ GradeType.d25mm.getGradeType());
			gradeTypeList.add(GradeType.FE500.getGradeType() + " "
					+ GradeType.d30mm.getGradeType());

			unitTypeList.add(UnitType.Mt.getUnitType());

		}
		materialObjectVo.setGradeTypeList(gradeTypeList);
		materialObjectVo.setUnitTypeList(unitTypeList);

		System.out.println(gradeTypeList.size());
		System.out.println(unitTypeList.size());

		return materialObjectVo;
	}

	@RequestMapping("/assignProject")
	@Transactional
	public ModelAndView assignProject(HttpServletRequest request,
			HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();
		List<String> projectName = new ArrayList<String>();
		List<String> projectSectName = new ArrayList<String>();
		for (Project project : userDao.getProjectList()) {
			projectName.add(project.getProjNm());
			projectSectName.add(project.getProjSect());
		}
		mv.addObject("projectName", projectName);
		mv.addObject("projSectName", projectSectName);
		mv.setViewName("assignProject");
		return mv;
	}

	@RequestMapping("/admin_profile")
	@Transactional
	public ModelAndView adminProfile(HttpServletRequest request,
			HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("admin_profile");
		return mv;
	}

	@RequestMapping("/labtech_storekeeper_profile")
	@Transactional
	public ModelAndView labtechStorekeeperProfile(HttpServletRequest request,
			HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("labtech_storekeeper_profile");
		return mv;
	}

	@RequestMapping("/sect_engg_profile")
	@Transactional
	public ModelAndView sectEnggProfile(HttpServletRequest request,
			HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("sect_engg_profile");
		return mv;
	}

	@RequestMapping("/site_engg_profile")
	@Transactional
	public ModelAndView siteEnggProfile(HttpServletRequest request,
			HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("site_engg_profile");
		return mv;
	}

	@RequestMapping("/pur_dept_profile")
	@Transactional
	public ModelAndView purDeptProfile(HttpServletRequest request,
			HttpServletResponse res) {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("pur_dept_profile");
		return mv;
	}

	@RequestMapping("/searchUser")
	@Transactional
	public @ResponseBody
	List<SearchUserVo> searchUser(HttpServletRequest request,
			HttpServletResponse res) {
		System.out.println("Inside serarchuser");
		List<SearchUserVo> searchUserVoList = new ArrayList<SearchUserVo>();
		System.out.println(request.getParameter("txtname"));
		if (request.getParameter("txtname") != null
				&& request.getParameter("txtname").length() != 0) {
			List<EmpDetails> empDetails = userDao.searchUser(request
					.getParameter("txtname"));

			if (empDetails != null) {
				for (EmpDetails empDetail : empDetails) {
					SearchUserVo searchUserVo = new SearchUserVo();
					searchUserVo.setEmpName(empDetail.getFirstNm() + " "
							+ empDetail.getLastNm());
					searchUserVo.setEmpRole(empDetail.getEmpRole());
					searchUserVo.setEmpUserNm(empDetail.getUserNm());
					if (empDetail.getEmployeeProjectJoins() != null) {
						for (EmployeeProjectJoin employeeProjectJoin : empDetail
								.getEmployeeProjectJoins()) {
							if (employeeProjectJoin.getProject() != null) {
								searchUserVo.setEmpProj(employeeProjectJoin
										.getProject().getProjNm()
										+ "-"
										+ employeeProjectJoin.getProject()
												.getProjSect());
							}
						}
					}
					searchUserVoList.add(searchUserVo);
				}
			}
		}
		System.out.println(searchUserVoList.size());
		return searchUserVoList;
	}

	@RequestMapping("/getPoForProject")
	@Transactional
	public @ResponseBody
	List<PoViewVo> getPoForProject(HttpServletRequest request,
			HttpServletResponse res) {
		System.out.println("Inside view po");

		DateFormat dateFormatyyyy = new SimpleDateFormat("yyyy-mm-dd");
		final List<PoViewVo> poViewVoList = new ArrayList<PoViewVo>();

		final String projectName = (String) request.getParameter("ddlprojname");
		String[] splitProjectName = projectName.split("-");

		Project project = userDao.getProject(splitProjectName[0],
				splitProjectName[1]);

		for (MatRequi matRequi : project.getMatRequis()) {

			for (RequiPur requiPur : matRequi.getRequiPurs()) {
				PurOrder purOrder = requiPur.getPurOrder();
				if (purOrder != null
						&& !isPoAlreadyPresent(purOrder, poViewVoList)) {
					PoViewVo poViewVo = new PoViewVo();
					poViewVo.setPoNo(purOrder.getPoNo());
					poViewVo.setDelDt(purOrder.getDetDt());

					for (ItemList itemList : matRequi.getItemLists()) {
						poViewVo.setItem(itemList.getItem());
						poViewVo.setItemGrade(itemList.getItemGrd());
						poViewVo.setItemQty(itemList.getItemQty());
					}
					poViewVo.setItemAmnt(purOrder.getPurRate());
					poViewVo.setUpstream(purOrder.getSupNm());
					poViewVoList.add(poViewVo);
				}
			}

		}

		System.out.println(poViewVoList.size());
		return poViewVoList;
	}

	@RequestMapping("/getPoForChallan")
	@Transactional
	public @ResponseBody
	List<PoViewVo> getPoForChallan(HttpServletRequest request,
			HttpServletResponse res) {
		System.out.println("Inside view po");

		DateFormat dateFormatyyyy = new SimpleDateFormat("yyyy-mm-dd");
		final List<PoViewVo> poViewVoList = new ArrayList<PoViewVo>();

		final String projectName = (String) request.getParameter("ddlprojname");
		String[] splitProjectName = projectName.split("-");

		Project project = userDao.getProject(splitProjectName[0],
				splitProjectName[1]);

		for (MatRequi matRequi : project.getMatRequis()) {

			for (RequiPur requiPur : matRequi.getRequiPurs()) {
				PurOrder purOrder = requiPur.getPurOrder();
				if (purOrder != null
						&& purOrder.getChallanDetailses().size() == 0) {
					if (!isPoAlreadyPresent(purOrder, poViewVoList)) {
						PoViewVo poViewVo = new PoViewVo();
						poViewVo.setPoNo(purOrder.getPoNo());
						poViewVo.setDelDt(purOrder.getDetDt());

						for (ItemList itemList : matRequi.getItemLists()) {
							poViewVo.setItem(itemList.getItem());
							poViewVo.setItemGrade(itemList.getItemGrd());
							poViewVo.setItemQty(itemList.getItemQty());
						}
						poViewVo.setItemAmnt(purOrder.getPurRate());
						poViewVo.setUpstream(purOrder.getSupNm());
						poViewVoList.add(poViewVo);
					}
				}
			}

		}

		System.out.println(poViewVoList.size());
		return poViewVoList;
	}

	@RequestMapping("/showPoDetailsUsingPoNo")
	@Transactional
	public @ResponseBody
	PoViewVo showPoDetailsUsingPoNo(HttpServletRequest request,
			HttpServletResponse res) {
		System.out.println("Inside showPoDetailsUsingPoNo po");
		DateFormat dateFormatyyyy = new SimpleDateFormat("dd-mm-yyyy");

		PoViewVo poViewVo = null;

		PurOrder purOrder = userDao.findPurOrder(Long.valueOf(request
				.getParameter("cb_po")));
		if (purOrder != null) {

			poViewVo = new PoViewVo();
			poViewVo.setPoNo(purOrder.getPoNo());
			poViewVo.setDelDt(purOrder.getDetDt());

			poViewVo.setChallanNo(Long.valueOf(userDao
					.getSequenceValue("challan_seq")));

			for (RequiPur requiPur : purOrder.getRequiPurs()) {
				poViewVo.setDelAddress(requiPur.getMatRequi().getProject()
						.getDelAddr());
			}

			for (RequiPur requiPur : purOrder.getRequiPurs()) {
				MatRequi matRequi = requiPur.getMatRequi();
				for (ItemList itemList : matRequi.getItemLists()) {
					poViewVo.setItem(itemList.getItem());
					poViewVo.setItemGrade(itemList.getItemGrd());

					poViewVo.setItemQty(itemList.getItemQty()
							+ (poViewVo.getItemQty() != null ? poViewVo
									.getItemQty() : 0));
					poViewVo.setItemAmnt(purOrder.getPurRate()
							+ (poViewVo.getItemAmnt() != null ? poViewVo
									.getItemAmnt() : 0));
					poViewVo.setItemUnit(itemList.getUnit());
				}
				poViewVo.setUpstream(purOrder.getSupNm());
			}
		}

		return poViewVo;
	}

	private boolean isPoAlreadyPresent(PurOrder purOrder,
			List<PoViewVo> poViewVoList) {
		boolean isPoAlreadyPresent = false;
		for (PoViewVo poViewVo : poViewVoList) {
			if (poViewVo.getPoNo().intValue() == purOrder.getPoNo().intValue()) {

				poViewVo.setItemQty(poViewVo.getItemQty()
						+ purOrder.getPurQty());
				poViewVo.setItemAmnt(poViewVo.getItemAmnt()
						+ purOrder.getPurRate());
				isPoAlreadyPresent = true;
			}
		}
		return isPoAlreadyPresent;
	}

	@RequestMapping("/reqView")
	@Transactional
	public @ResponseBody
	List<RequisitionViewVo> viewRequisition(HttpServletRequest request,
			HttpServletResponse res) {
		System.out.println("Inside view req");

		DateFormat dateFormatdd = new SimpleDateFormat("dd-mm-yyyy");
		final List<RequisitionViewVo> reqViewList = new ArrayList<RequisitionViewVo>();

		final String projectName = (String) request.getParameter("ddlprojname");
		String[] splitProjectName = projectName.split("-");

		Project project = userDao.getProject(splitProjectName[0],
				splitProjectName[1]);

		for (MatRequi matRequi : project.getMatRequis()) {
			RequisitionViewVo requisitionViewVo = new RequisitionViewVo();
			requisitionViewVo.setReqNo(matRequi.getReqNo());
			requisitionViewVo.setDateGen(dateFormatdd.format(matRequi
					.getDateGen()));
			requisitionViewVo.setExpectedDt(dateFormatdd.format(matRequi
					.getExpectedDt()));
			requisitionViewVo.setStatus(matRequi.getReqSts());
			requisitionViewVo.setRequestedBy(matRequi.getRequestedBy());

			for (ItemList item : matRequi.getItemLists()) {
				requisitionViewVo.setItem(item.getItem());
				requisitionViewVo.setItemGrade(item.getItemGrd());
			}

			reqViewList.add(requisitionViewVo);
		}

		Collections.sort(reqViewList, new Comparator<RequisitionViewVo>() {

			public int compare(RequisitionViewVo reqView1,
					RequisitionViewVo reqView2) {

				Long reqNo1 = reqView1.getReqNo();
				Long reqNo2 = reqView2.getReqNo();

				// ascending order
				return reqNo1.compareTo(reqNo2);
			}
		});
		System.out.println(reqViewList.size());
		return reqViewList;
	}

	@RequestMapping("/reqViewForAuthorization")
	@Transactional
	public @ResponseBody
	List<RequisitionViewVo> reqViewForAuthorization(HttpServletRequest request,
			HttpServletResponse res) {
		System.out.println("Inside view req");

		DateFormat dateFormatdd = new SimpleDateFormat("dd-mm-yyyy");
		final List<RequisitionViewVo> reqViewList = new ArrayList<RequisitionViewVo>();

		final String projectName = (String) request.getParameter("ddlprojname");
		String[] splitProjectName = projectName.split("-");

		Project project = userDao.getProject(splitProjectName[0],
				splitProjectName[1]);

		for (MatRequi matRequi : project.getMatRequis()) {
			if (!matRequi.isAuthorizeSectEngg()) {
				RequisitionViewVo requisitionViewVo = new RequisitionViewVo();
				requisitionViewVo.setReqNo(matRequi.getReqNo());
				requisitionViewVo.setDateGen(dateFormatdd.format(matRequi
						.getDateGen()));
				requisitionViewVo.setExpectedDt(dateFormatdd.format(matRequi
						.getExpectedDt()));
				requisitionViewVo.setStatus(matRequi.getReqSts());

				for (ItemList item : matRequi.getItemLists()) {
					requisitionViewVo.setItem(item.getItem());
					requisitionViewVo.setItemGrade(item.getItemGrd());
				}

				reqViewList.add(requisitionViewVo);
			}
		}

		System.out.println(reqViewList.size());
		return reqViewList;
	}

	@RequestMapping("/detailsRequisition")
	@Transactional
	public @ResponseBody
	ModelAndView detailsRequisition(HttpServletRequest request,
			HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();

		MatRequi matRequi = userDao.findMatRequi(new Long(request
				.getParameter("Id")));
		modelAndView.addObject("rpNo", matRequi.getReqNo());
		modelAndView.addObject("gdate", matRequi.getDateGen());
		modelAndView.addObject("expectedDate", matRequi.getExpectedDt());
		modelAndView.addObject("justification", matRequi.getJustification());
		modelAndView.addObject("employeeName", matRequi.getRequestedBy());
		for (ItemList itemList : matRequi.getItemLists()) {
			modelAndView.addObject("ddlitem", itemList.getItem());
			modelAndView.addObject("ddlgrade", itemList.getItemGrd());
			modelAndView.addObject("txtquantity", itemList.getItemQty());
			modelAndView.addObject("ddlunit", itemList.getUnit());
			modelAndView.addObject("txtusedfor", itemList.getUsedFor());

		}

		modelAndView.addObject("ddljProjName", matRequi.getProject()
				.getProjNm() + "-" + matRequi.getProject().getProjSect());

		modelAndView.setViewName("request_view_page");
		return modelAndView;
	}

	@RequestMapping("/detailsPo")
	@Transactional
	public @ResponseBody
	ModelAndView detailsPo(HttpServletRequest request, HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();

		PurOrder purOrder = userDao.findPurOrder(new Long(request
				.getParameter("Id")));

		for (RequiPur requiPur : purOrder.getRequiPurs()) {
			for (ItemList itemList : requiPur.getMatRequi().getItemLists()) {
				modelAndView.addObject("item", itemList.getItem());
				modelAndView.addObject("itemqty", itemList.getItemQty());
				modelAndView.addObject("itemgrade", itemList.getItemGrd());
			}

		}

		modelAndView.addObject("poNo", purOrder.getPoNo());

		modelAndView.addObject("amount", purOrder.getPurRate());

		modelAndView.addObject("upstream", purOrder.getSupNm());
		modelAndView.addObject("delDt", purOrder.getDetDt());
		modelAndView.addObject("delAddr", purOrder.getSupNm());

		modelAndView.setViewName("po_view_page");
		return modelAndView;
	}

	@RequestMapping("/fetchEmployee")
	@Transactional
	public @ResponseBody
	EmpDetailsVo fetchEmployee(HttpServletRequest request,
			HttpServletResponse res) {
		System.out.println("Inside fetchEmployee");

		System.out.println(request.getParameter("rb_emp"));
		EmpLogin empLogin = userDao.find(request.getParameter("rb_emp"));

		if (empLogin != null && empLogin.getEmpDetails() != null) {
			System.out.println(empLogin.getEmpDetails());
			EmpDetails empDetails = empLogin.getEmpDetails();

			EmpDetailsVo detailsVo = new EmpDetailsVo();
			detailsVo.setUserNm(empDetails.getUserNm());
			detailsVo.setFirstNm(empDetails.getFirstNm());
			detailsVo.setMiddleNm(empDetails.getMidNm());
			detailsVo.setLastNm(empDetails.getLastNm());
			detailsVo.setTel1(empDetails.getEmpTel1());
			detailsVo.setTel2(empDetails.getEmpTel2());
			detailsVo.setEmpAddr(empDetails.getEmpAddr());
			detailsVo.setEmpEmail(empDetails.getEmpEmail());
			detailsVo.setEmpRole(empDetails.getEmpRole());

			return detailsVo;
		}

		return null;

	}

	@RequestMapping("/updateEmployee")
	@Transactional
	@ResponseBody
	public int updateEmployeeDetails(HttpServletRequest request,
			HttpServletResponse res) {
		/**
		 * If error is found then send the default value.
		 */
		int employeeUpdateValue = -1;

		System.out.println(request.getParameter("txtusername"));
		EmpLogin empLogin = userDao.find(request.getParameter("txtusername"));
		String firstNm = request.getParameter("txtfname");
		String middleNm = request.getParameter("txtmname");
		String lastNm = request.getParameter("txtlname");
		String tel1 = request.getParameter("txtmobile");
		String tel2 = request.getParameter("txtaltnum");
		String empAddr = request.getParameter("taaddress");
		String empEmail = request.getParameter("txtemail");
		String empRole = request.getParameter("ddl_role");

		if (empLogin != null) {
			EmpDetails empDetails = empLogin.getEmpDetails();
			if (!firstNm.equalsIgnoreCase(empDetails.getFirstNm())
					|| !middleNm.equalsIgnoreCase(empDetails.getMidNm())
					|| !lastNm.equalsIgnoreCase(empDetails.getLastNm())
					|| !tel1.equalsIgnoreCase(empDetails.getEmpTel1())
					|| !tel2.equalsIgnoreCase(empDetails.getEmpTel2())
					|| !empAddr.equalsIgnoreCase(empDetails.getEmpAddr())
					|| !empEmail.equalsIgnoreCase(empDetails.getEmpEmail())
					|| !empRole.equalsIgnoreCase(empDetails.getEmpRole())) {
				empLogin.getEmpDetails().setFirstNm(firstNm);
				empLogin.getEmpDetails().setMidNm(middleNm);
				empLogin.getEmpDetails().setLastNm(lastNm);
				empLogin.getEmpDetails().setEmpTel1(tel1);
				empLogin.getEmpDetails().setEmpTel2(tel2);
				empLogin.getEmpDetails().setEmpAddr(empAddr);
				empLogin.getEmpDetails().setEmpEmail(empEmail);
				empLogin.getEmpDetails().setEmpRole(empRole);
				userDao.update(empLogin);
				/**
				 * record has been updated.
				 */
				employeeUpdateValue = 1;

			} else {
				/**
				 * no value has been changed.
				 */
				employeeUpdateValue = 2;
			}

		} else {
			/**
			 * In case the user is not found in db.
			 */
			employeeUpdateValue = 3;
		}
		return employeeUpdateValue;
	}

	@RequestMapping("/request_add")
	@Transactional
	public ModelAndView addRequestPage(HttpServletRequest request,
			HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		List<String> projectName = new ArrayList<String>();

		modelAndView.addObject("reqNo",
				userDao.getSequenceValue("mat_requi_seq"));
		modelAndView.addObject("materialType",
				Arrays.asList(MaterialType.values()));

		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("USERNAME");

		if (userName != null) {
			EmpLogin empLogin = userDao.find(userName);
			if (empLogin != null && empLogin.getEmpDetails() != null) {
				modelAndView.addObject("employeeName", empLogin.getEmpDetails()
						.getFirstNm()
						+ " "
						+ empLogin.getEmpDetails().getLastNm());

				for (EmployeeProjectJoin employeeProjectJoin : empLogin
						.getEmpDetails().getEmployeeProjectJoins()) {
					if (employeeProjectJoin.getProject() != null) {
						projectName.add(employeeProjectJoin.getProject()
								.getProjNm()
								+ "-"
								+ employeeProjectJoin.getProject()
										.getProjSect());
					}
				}
			}
		}
		modelAndView.addObject("projectName", projectName);
		modelAndView.setViewName("request_add");
		return modelAndView;
	}

	@RequestMapping("/request_view")
	@Transactional
	public ModelAndView viewRequestPage(HttpServletRequest request,
			HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		List<String> projectName = new ArrayList<String>();

		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("USERNAME");

		if (userName != null) {
			EmpLogin empLogin = userDao.find(userName);
			for (EmployeeProjectJoin employeeProjectJoin : empLogin
					.getEmpDetails().getEmployeeProjectJoins()) {
				Project project = employeeProjectJoin.getProject();
				projectName.add(project.getProjNm() + "-"
						+ project.getProjSect());
			}
		}

		/*
		 * for (Project project : userDao.getProjectList()) {
		 * projectName.add(project.getProjNm() + "-" + project.getProjSect()); }
		 */
		modelAndView.addObject("projectName", projectName);
		modelAndView.setViewName("request_view");
		return modelAndView;
	}

	@RequestMapping("/request_update_delete")
	@Transactional
	public ModelAndView requestUpdateDelete(HttpServletRequest request,
			HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		List<String> projectName = new ArrayList<String>();

		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("USERNAME");

		if (userName != null) {
			EmpLogin empLogin = userDao.find(userName);
			for (EmployeeProjectJoin employeeProjectJoin : empLogin
					.getEmpDetails().getEmployeeProjectJoins()) {
				Project project = employeeProjectJoin.getProject();
				projectName.add(project.getProjNm() + "-"
						+ project.getProjSect());
			}
		}
		modelAndView.addObject("projectName", projectName);
		modelAndView.setViewName("request_update_delete");
		return modelAndView;
	}

	@RequestMapping("/request_auth")
	@Transactional
	public ModelAndView requestAuth(HttpServletRequest request,
			HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		List<String> projectName = new ArrayList<String>();

		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("USERNAME");

		if (userName != null) {
			EmpLogin empLogin = userDao.find(userName);
			for (EmployeeProjectJoin employeeProjectJoin : empLogin
					.getEmpDetails().getEmployeeProjectJoins()) {
				Project project = employeeProjectJoin.getProject();
				projectName.add(project.getProjNm() + "-"
						+ project.getProjSect());
			}
		}

		modelAndView.addObject("projectName", projectName);
		modelAndView.setViewName("request_auth");
		return modelAndView;
	}

	@RequestMapping("/request_tracking")
	@Transactional
	public ModelAndView requestTracking(HttpServletRequest request,
			HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		List<String> projectName = new ArrayList<String>();

		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("USERNAME");

		if (userName != null) {
			EmpLogin empLogin = userDao.find(userName);
			for (EmployeeProjectJoin employeeProjectJoin : empLogin
					.getEmpDetails().getEmployeeProjectJoins()) {
				Project project = employeeProjectJoin.getProject();
				projectName.add(project.getProjNm() + "-"
						+ project.getProjSect());
			}
		}

		modelAndView.addObject("projectName", projectName);
		modelAndView.setViewName("request_tracking");
		return modelAndView;
	}

	@RequestMapping("/challan_add")
	@Transactional
	public ModelAndView addChallanPage(HttpServletRequest request,
			HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		List<String> projectName = new ArrayList<String>();

		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("USERNAME");

		if (userName != null) {
			EmpLogin empLogin = userDao.find(userName);
			for (EmployeeProjectJoin employeeProjectJoin : empLogin
					.getEmpDetails().getEmployeeProjectJoins()) {
				Project project = employeeProjectJoin.getProject();
				projectName.add(project.getProjNm() + "-"
						+ project.getProjSect());
			}
		}
		modelAndView.addObject("projectName", projectName);
		modelAndView.setViewName("challan_add");
		return modelAndView;
	}

	@RequestMapping("/challan_view")
	@Transactional
	public ModelAndView viewChallanPage(HttpServletRequest request,
			HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		List<String> projectName = new ArrayList<String>();

		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("USERNAME");

		if (userName != null) {
			EmpLogin empLogin = userDao.find(userName);
			for (EmployeeProjectJoin employeeProjectJoin : empLogin
					.getEmpDetails().getEmployeeProjectJoins()) {
				Project project = employeeProjectJoin.getProject();
				projectName.add(project.getProjNm() + "-"
						+ project.getProjSect());
			}
		}
		modelAndView.addObject("projectName", projectName);
		modelAndView.setViewName("challan_view");
		return modelAndView;
	}

	@RequestMapping("/challan_auth")
	@Transactional
	public ModelAndView autohrizeChallanPage(HttpServletRequest request,
			HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		List<String> projectName = new ArrayList<String>();

		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("USERNAME");

		if (userName != null) {
			EmpLogin empLogin = userDao.find(userName);
			for (EmployeeProjectJoin employeeProjectJoin : empLogin
					.getEmpDetails().getEmployeeProjectJoins()) {
				Project project = employeeProjectJoin.getProject();
				projectName.add(project.getProjNm() + "-"
						+ project.getProjSect());
			}
		}
		modelAndView.addObject("projectName", projectName);
		modelAndView.setViewName("challan_auth");
		return modelAndView;
	}

	@RequestMapping("/po_view")
	@Transactional
	public ModelAndView viewPoPage(HttpServletRequest request,
			HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		List<String> projectName = new ArrayList<String>();

		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("USERNAME");

		if (userName != null) {
			EmpLogin empLogin = userDao.find(userName);
			for (EmployeeProjectJoin employeeProjectJoin : empLogin
					.getEmpDetails().getEmployeeProjectJoins()) {
				Project project = employeeProjectJoin.getProject();
				projectName.add(project.getProjNm() + "-"
						+ project.getProjSect());
			}
		}
		modelAndView.addObject("projectName", projectName);
		modelAndView.setViewName("po_view");
		return modelAndView;
	}

	@RequestMapping("/po_add")
	@Transactional
	public ModelAndView addPurchaseOrder(HttpServletRequest request,
			HttpServletResponse res) {
		ModelAndView modelAndView = new ModelAndView();
		List<String> projectName = new ArrayList<String>();

		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("USERNAME");

		if (userName != null) {
			EmpLogin empLogin = userDao.find(userName);
			for (EmployeeProjectJoin employeeProjectJoin : empLogin
					.getEmpDetails().getEmployeeProjectJoins()) {
				Project project = employeeProjectJoin.getProject();
				projectName.add(project.getProjNm() + "-"
						+ project.getProjSect());
			}
		}
		modelAndView.addObject("projectName", projectName);
		modelAndView.setViewName("po_add");
		return modelAndView;
	}

	@RequestMapping("/populatePoDetails")
	@Transactional
	@ResponseBody
	public List<String> populatePoDetails(HttpServletRequest request,
			HttpServletResponse res) {

		List<String> attributes = new ArrayList<String>();
		String materialRequisitionNumber = request
				.getParameter("checkboxRequi");
		System.out.println(materialRequisitionNumber);
		if (materialRequisitionNumber != null) {

			materialRequisitionNumber = materialRequisitionNumber.replace("\"",
					"");
			materialRequisitionNumber = materialRequisitionNumber.replace("[",
					"");
			materialRequisitionNumber = materialRequisitionNumber.replace("]",
					"");
			String[] splitMaterialRequiNo = materialRequisitionNumber
					.split(",");

			List<MatRequi> matRequiList = new ArrayList<MatRequi>();
			List<String> itemNameList = new ArrayList<String>();

			for (final String matRequiNo : splitMaterialRequiNo) {
				System.out.println(matRequiNo);
				if (!"null".equalsIgnoreCase(matRequiNo)) {
					MatRequi matRequi = userDao.findMatRequi(new Long(
							matRequiNo));
					for (ItemList list : matRequi.getItemLists()) {
						itemNameList.add(list.getItem());
					}
					matRequiList.add(matRequi);
				}
			}

			boolean isItemSame = true;
			if (itemNameList.size() > 0) {
				String tempItemName = itemNameList.get(0);
				for (String itemName : itemNameList) {
					if (!tempItemName.equalsIgnoreCase(itemName)) {
						isItemSame = false;
						break;
					}
				}

				if (!isItemSame) {
					attributes.add("false");
				} else {
					attributes.add(userDao.getSequenceValue(
							"purchase_order_seq").toString());
					attributes.add(tempItemName);
				}
			}

		}
		System.out.println("attributes " + attributes);
		System.out.println("attributes " + attributes.size());
		return attributes;
	}

	@RequestMapping("/generatePurchaseOrder")
	@Transactional
	@ResponseBody
	public void generatePurchaseOrder(HttpServletRequest request,
			HttpServletResponse res) throws ParseException {

		DateFormat dateFormatdd = new SimpleDateFormat("dd-mm-yyyy");

		String materialRequisitionNumber = request
				.getParameter("checkboxRequi");
		String poNo = request.getParameter("txtpono");
		String item = request.getParameter("txtitem");
		BigDecimal amt = new BigDecimal(request.getParameter("txtamount"));
		String vendor = request.getParameter("txtupstream");
		Date delDate = dateFormatdd.parse(request.getParameter("txtdeldate"));
		String termsCond = request.getParameter("tatc");

		PurOrder purOrder = new PurOrder();
		purOrder.setDetDt(new Date());
		purOrder.setPoDt(new Date());
		purOrder.setPoNo(new Long(poNo));
		purOrder.setSupNm(vendor);
		purOrder.setPurRate(amt.doubleValue());

		System.out.println(materialRequisitionNumber);
		List<MatRequi> matRequiList = new ArrayList<MatRequi>();

		if (materialRequisitionNumber != null) {

			materialRequisitionNumber = materialRequisitionNumber.replace("\"",
					"");
			materialRequisitionNumber = materialRequisitionNumber.replace("[",
					"");
			materialRequisitionNumber = materialRequisitionNumber.replace("]",
					"");
			String[] splitMaterialRequiNo = materialRequisitionNumber
					.split(",");

			for (final String matRequiNo : splitMaterialRequiNo) {

				System.out.println(matRequiNo);
				if (!"null".equalsIgnoreCase(matRequiNo)) {

					MatRequi matRequi = userDao.findMatRequi(new Long(
							matRequiNo));

					RequiPur requiPur = new RequiPur();
					requiPur.setMatRequi(matRequi);
					requiPur.setPurOrder(purOrder);
					matRequi.getRequiPurs().add(requiPur);
					matRequi.setReqSts(ReqStatus.pur_order_added.getReqStatus());
					// purOrder.getRequiPurs().add(requiPur);
					// userDao.updateMatRequi(matRequi);
					matRequiList.add(matRequi);
				}
			}

		}

		for (MatRequi matRequiPersist : matRequiList) {

			userDao.updateMatRequi(matRequiPersist);
		}

	}

	@RequestMapping("/updateRequest")
	@Transactional
	@ResponseBody
	public RequisitionViewVo updateRequest(HttpServletRequest request,
			HttpServletResponse res) throws ParseException {

		DateFormat dateFormatdd = new SimpleDateFormat("dd-mm-yyyy");
		RequisitionViewVo requisitionViewVo = new RequisitionViewVo();
		String materialRequisitionNumber = request
				.getParameter("checkboxRequi");

		System.out.println(materialRequisitionNumber);

		if (materialRequisitionNumber != null) {

			materialRequisitionNumber = materialRequisitionNumber.replace("\"",
					"");
			materialRequisitionNumber = materialRequisitionNumber.replace("[",
					"");
			materialRequisitionNumber = materialRequisitionNumber.replace("]",
					"");
			String[] splitMaterialRequiNo = materialRequisitionNumber
					.split(",");

			for (final String matRequiNo : splitMaterialRequiNo) {

				System.out.println(matRequiNo);
				if (!"null".equalsIgnoreCase(matRequiNo)) {
					MatRequi matRequi = userDao.findMatRequi(new Long(
							matRequiNo));
					requisitionViewVo.setReqNo(matRequi.getReqNo());

					requisitionViewVo.setDateGen(dateFormatdd.format(matRequi
							.getDateGen()));
					requisitionViewVo.setExpectedDt(dateFormatdd
							.format(matRequi.getExpectedDt()));
					System.out.println(requisitionViewVo.getDateGen());
					System.out.println(requisitionViewVo.getExpectedDt());
					requisitionViewVo.setRequestedBy(matRequi.getRequestedBy());
					requisitionViewVo.setStatus(matRequi.getReqSts());

					for (ItemList itemList : matRequi.getItemLists()) {
						requisitionViewVo.setItem(itemList.getItem());
						requisitionViewVo.setItemGrade(itemList.getItemGrd());
						requisitionViewVo.setItemUnit(itemList.getUnit());
						requisitionViewVo.setItemQty(itemList.getItemQty());
					}
				}
			}

		}
		return requisitionViewVo;
	}

	@RequestMapping("/updateRequisition")
	@Transactional
	@ResponseBody
	public boolean updateRequisition(HttpServletRequest request,
			HttpServletResponse res) throws ParseException {

		boolean requisitionAdded = false;
		DateFormat dateFormatdd = new SimpleDateFormat("dd-mm-yyyy");
		DateFormat dateFormatyyyy = new SimpleDateFormat("yyyy-mm-dd");

		// HttpSession session = request.getSession();
		// String userName = (String) session.getAttribute("USERNAME");

		// if (userName != null) {
		// EmpLogin empLogin = userDao.find(userName);
		MatRequi matRequi = userDao.findMatRequi(Long.valueOf(request
				.getParameter("txtreqno")));
		// matRequi.setReqNo(Long.valueOf(request.getParameter("txt_reqno")));
		System.out.println("generation date : "
				+ request.getParameter("txt_gdate"));
		matRequi.setDateGen(dateFormatdd.parse(request
				.getParameter("txt_gdate")));
		System.out.println("expected date : "
				+ request.getParameter("txt_expdate"));
		matRequi.setExpectedDt(dateFormatdd.parse(request
				.getParameter("txt_expdate")));

		matRequi.setReqSts(request.getParameter("txtstatus"));

		String projectName = request.getParameter("formddlprojname");
		for (Project project : userDao.getProjectList()) {
			if (projectName != null && !projectName.isEmpty()) {
				System.out.println(matRequi.getProject().getProjectId());
				System.out.println(project.getProjectId());
				String[] splitProjectName = projectName.split("-");
				if (splitProjectName.length > 1
						&& splitProjectName[0].equalsIgnoreCase(project
								.getProjNm())
						&& splitProjectName[1].equalsIgnoreCase(project
								.getProjSect())
						&& matRequi.getProject().getProjectId() != project
								.getProjectId()) {
					System.out.println("Inside here");
					/**
					 * Will reach here only in case the project entered by user
					 * is different then the original one.
					 */
					matRequi.getProject().getMatRequis().remove(matRequi);
					matRequi.setProject(project);
					project.getMatRequis().add(matRequi);
				}
			}
		}

		Set<ItemList> itemListSet = matRequi.getItemLists();

		for (ItemList itemList : itemListSet) {
			itemList.setItemQty(Double.valueOf(request
					.getParameter("txtquantity")));
			itemList.setUnit(request.getParameter("ddlunit"));
			if (!(GradeType.N_A.getGradeType().equalsIgnoreCase(request
					.getParameter("ddlgrade")))) {
				System.out.println(request.getParameter("ddlgrade"));
				itemList.setItemGrd(request.getParameter("ddlgrade"));
			}
		}

		userDao.updateMatRequi(matRequi);
		requisitionAdded = true;
		// }
		return requisitionAdded;
	}

	@RequestMapping("/deleteRequisition")
	@Transactional
	@ResponseBody
	public boolean deleteRequisition(HttpServletRequest request,
			HttpServletResponse res) throws ParseException {

		boolean requisitionDeleted = false;
		String materialRequisitionNumber = request
				.getParameter("checkboxRequi");

		System.out.println(materialRequisitionNumber);

		if (materialRequisitionNumber != null) {

			materialRequisitionNumber = materialRequisitionNumber.replace("\"",
					"");
			materialRequisitionNumber = materialRequisitionNumber.replace("[",
					"");
			materialRequisitionNumber = materialRequisitionNumber.replace("]",
					"");
			String[] splitMaterialRequiNo = materialRequisitionNumber
					.split(",");

			for (final String matRequiNo : splitMaterialRequiNo) {

				System.out.println(matRequiNo);
				if (!"null".equalsIgnoreCase(matRequiNo)) {
					MatRequi matRequi = userDao.findMatRequi(new Long(
							matRequiNo));
					matRequi.setProject(null);
					userDao.deleteMatRequi(matRequi);
					requisitionDeleted = true;
				}
			}
		}
		return requisitionDeleted;
	}

	@RequestMapping("/authorizeRequisition")
	@Transactional
	@ResponseBody
	public boolean authorizeRequisition(HttpServletRequest request,
			HttpServletResponse res) throws ParseException {

		boolean requisitionAuthorized = false;
		String materialRequisitionNumber = request
				.getParameter("checkboxRequi");

		System.out.println(materialRequisitionNumber);

		if (materialRequisitionNumber != null) {

			materialRequisitionNumber = materialRequisitionNumber.replace("\"",
					"");
			materialRequisitionNumber = materialRequisitionNumber.replace("[",
					"");
			materialRequisitionNumber = materialRequisitionNumber.replace("]",
					"");
			String[] splitMaterialRequiNo = materialRequisitionNumber
					.split(",");

			for (final String matRequiNo : splitMaterialRequiNo) {

				System.out.println(matRequiNo);
				if (!"null".equalsIgnoreCase(matRequiNo)) {
					MatRequi matRequi = userDao.findMatRequi(new Long(
							matRequiNo));
					matRequi.setReqSts(ReqStatus.req_authorize.getReqStatus());
					matRequi.setAuthorizeSectEngg(true);
					userDao.updateMatRequi(matRequi);
					requisitionAuthorized = true;
				}
			}
		}
		return requisitionAuthorized;
	}

	@RequestMapping("/addChallan")
	@Transactional
	@ResponseBody
	public boolean addChallan(HttpServletRequest request,
			HttpServletResponse res) throws ParseException {

		DateFormat dateFormatdd = new SimpleDateFormat("dd-mm-yyyy");
		boolean challanAdded = false;
		ChallanDetails challanDetails = new ChallanDetails();

		challanDetails.setChNo(request.getParameter("txtchallno"));
		challanDetails.setChnItem(request.getParameter("td_item"));
		challanDetails.setDelAddr(request.getParameter("tadeladdress"));
		challanDetails.setDelDt(dateFormatdd.parse(request
				.getParameter("txtrdate")));
		challanDetails.setItmGrd(request.getParameter("td_grade"));
		challanDetails
				.setItmQty(Double.valueOf(request.getParameter("td_qty")));

		PurOrder purOrder = userDao.findPurOrder(Long.valueOf(request
				.getParameter("txtpono")));
		challanDetails.setPurOrder(purOrder);
		purOrder.getChallanDetailses().add(challanDetails);

		userDao.addChallanDetails(challanDetails);
		challanAdded = true;

		return challanAdded;
	}

	@RequestMapping("/getChallanForProject")
	@Transactional
	public @ResponseBody
	List<ChallanViewVo> getChallanForProject(HttpServletRequest request,
			HttpServletResponse res) {
		System.out.println("Inside view challan");

		DateFormat dateFormatdd = new SimpleDateFormat("dd-mm-yyyy");
		final List<ChallanViewVo> challanViewVoList = new ArrayList<ChallanViewVo>();

		final String projectName = (String) request.getParameter("ddlprojname");
		String[] splitProjectName = projectName.split("-");

		Project project = userDao.getProject(splitProjectName[0],
				splitProjectName[1]);

		for (MatRequi matRequi : project.getMatRequis()) {

			for (RequiPur requiPur : matRequi.getRequiPurs()) {
				PurOrder purOrder = requiPur.getPurOrder();
				if (purOrder != null && purOrder.getChallanDetailses() != null
						&& purOrder.getChallanDetailses().size() > 0) {

					for (ChallanDetails challanDetails : purOrder
							.getChallanDetailses()) {
						ChallanViewVo challanViewVo = new ChallanViewVo();
						challanViewVo.setChallanNo(Long.valueOf(challanDetails
								.getChNo()));
						challanViewVo.setPoNo(purOrder.getPoNo());
						challanViewVo
								.setDelAddress(challanDetails.getDelAddr());
						challanViewVo.setDelDt(dateFormatdd
								.format(challanDetails.getDelDt()));
						challanViewVo.setItem(challanDetails.getChnItem());
						challanViewVo.setItemGrade(challanDetails.getItmGrd());
						challanViewVo.setItemQty(challanDetails.getItmQty());
						challanViewVo.setUpstream(purOrder.getSupNm());
						challanViewVoList.add(challanViewVo);
					}
				}
			}

		}

		Collections.sort(challanViewVoList, new Comparator<ChallanViewVo>() {

			public int compare(ChallanViewVo challanView1,
					ChallanViewVo challanView2) {

				Long challanNo1 = challanView1.getChallanNo();
				Long challanNo2 = challanView2.getChallanNo();

				// ascending order
				return challanNo1.compareTo(challanNo2);
			}
		});
		System.out.println(challanViewVoList.size());
		return challanViewVoList;
	}

	@RequestMapping("/getChallanToAuthorizeForProject")
	@Transactional
	public @ResponseBody
	List<ChallanViewVo> getChallanToAuthorizeForProject(
			HttpServletRequest request, HttpServletResponse res) {
		System.out.println("Inside view challan");

		DateFormat dateFormatdd = new SimpleDateFormat("dd-mm-yyyy");
		final List<ChallanViewVo> challanViewVoList = new ArrayList<ChallanViewVo>();

		final String projectName = (String) request.getParameter("ddlprojname");
		String[] splitProjectName = projectName.split("-");

		Project project = userDao.getProject(splitProjectName[0],
				splitProjectName[1]);

		String empRole = null;
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("USERNAME");
		if (userName != null) {
			EmpLogin empLogin = userDao.find(userName);
			empRole = empLogin.getEmpDetails().getEmpRole();
		}

		for (MatRequi matRequi : project.getMatRequis()) {

			for (RequiPur requiPur : matRequi.getRequiPurs()) {
				PurOrder purOrder = requiPur.getPurOrder();
				if (purOrder != null && purOrder.getChallanDetailses() != null
						&& purOrder.getChallanDetailses().size() > 0) {

					for (ChallanDetails challanDetails : purOrder
							.getChallanDetailses()) {
						if ((RoleType.LAB_TECHNICIAN.getRoleType()
								.equalsIgnoreCase(empRole) && !challanDetails
								.isAuthorizeLabTech())
								|| (RoleType.Sector_Engineer.getRoleType()
										.equalsIgnoreCase(empRole) && !challanDetails
										.isAuthorizeSectEngg())) {
							ChallanViewVo challanViewVo = new ChallanViewVo();
							challanViewVo.setChallanNo(Long
									.valueOf(challanDetails.getChNo()));
							challanViewVo.setPoNo(purOrder.getPoNo());
							challanViewVo.setDelAddress(challanDetails
									.getDelAddr());
							challanViewVo.setDelDt(dateFormatdd
									.format(challanDetails.getDelDt()));
							challanViewVo.setItem(challanDetails.getChnItem());
							challanViewVo.setItemGrade(challanDetails
									.getItmGrd());
							challanViewVo
									.setItemQty(challanDetails.getItmQty());
							challanViewVo.setUpstream(purOrder.getSupNm());
							challanViewVoList.add(challanViewVo);

						}
					}
				}
			}

		}

		System.out.println(challanViewVoList.size());
		return challanViewVoList;
	}

	@RequestMapping("/authorizeChallan")
	@Transactional
	@ResponseBody
	public boolean authorizeChallan(HttpServletRequest request,
			HttpServletResponse res) throws ParseException {

		boolean challanAuthorized = false;
		String challanAuthorizedNumber = request.getParameter("checkboxRequi");

		System.out.println(challanAuthorizedNumber);

		String empRole = null;
		HttpSession session = request.getSession();
		String userName = (String) session.getAttribute("USERNAME");
		if (userName != null) {
			EmpLogin empLogin = userDao.find(userName);
			empRole = empLogin.getEmpDetails().getEmpRole();
		}

		if (challanAuthorizedNumber != null) {

			challanAuthorizedNumber = challanAuthorizedNumber.replace("\"", "");
			challanAuthorizedNumber = challanAuthorizedNumber.replace("[", "");
			challanAuthorizedNumber = challanAuthorizedNumber.replace("]", "");
			String[] splitChallanAuthorizedNumber = challanAuthorizedNumber
					.split(",");

			for (final String challanNo : splitChallanAuthorizedNumber) {

				System.out.println(challanNo);
				if (!"null".equalsIgnoreCase(challanNo)) {
					ChallanDetails challanDetails = userDao
							.findChallan(challanNo);
					if (RoleType.LAB_TECHNICIAN.getRoleType().equalsIgnoreCase(
							empRole)) {
						challanDetails.setAuthorizeLabTech(true);
					} else {
						challanDetails.setAuthorizeSectEngg(true);
					}

					userDao.updateChallanDetails(challanDetails);
					challanAuthorized = true;
				}
			}
		}
		return challanAuthorized;
	}

	@RequestMapping("/getUserId")
	@Transactional
	public @ResponseBody
	List<String> getUserId(HttpServletRequest request, HttpServletResponse res) {
		System.out.println("Inside getUserId");
		List<String> searchUserVoList = new ArrayList<String>();

		System.out.println(request.getParameter("name"));
		if (request.getParameter("name") != null
				&& request.getParameter("name").length() != 0) {
			searchUserVoList = userDao.findEmployeeUserName(request
					.getParameter("name"));

		}
		System.out.println(searchUserVoList.size());
		return searchUserVoList;
	}
}
