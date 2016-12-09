package weixin.idea.award.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import weixin.idea.award.entity.AwardEntity;
import weixin.idea.award.service.AwardServiceI;



@Controller
@RequestMapping("/awardController")
public class AwardController extends BaseController {
	
	private static final Logger logger = Logger.getLogger(AwardController.class);

	@Autowired
	private AwardServiceI awardService;
	@Autowired
	private SystemService systemService;
	
	private String message;
	
	public String getMessage(){
		return message;
	}
	
	public void setMessage(String message){
		this.message = message;
	}
	
	/**
	 * 奖品列表跳转
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView award(HttpServletRequest request){
		return new ModelAndView("weixin/idea/award/award/awardList");
	}
	
	/**
	 * 奖品
	 * @param award
	 * @param request
	 * @param response
	 * @param dataGrid
	 */
	@RequestMapping(params = "datagrid")
	public void datagrid(AwardEntity award,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid){
		CriteriaQuery cq = new CriteriaQuery(AwardEntity.class,dataGrid);
		cq.eq("accountid", ResourceUtil.getWeiXinAccountId());
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				award,request.getParameterMap());
		this.awardService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 删除奖品记录
	 * @param award
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "del")
	@ResponseBody
	public AjaxJson del(AwardEntity award, HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		award = systemService.getEntity(AwardEntity.class, award.getId());
		message = "奖品记录删除成功";
		awardService.delete(award);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 添加奖品记录
	 * @param award
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "save")
	@ResponseBody
	public AjaxJson save(AwardEntity award, HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		if(StringUtil.isNotEmpty(award.getId())){
			message = "奖品记录更新成功";
			AwardEntity t = awardService.get(AwardEntity.class, award.getId());
			try{
				MyBeanUtils.copyBeanNotNull2Bean(award,t);
				awardService.saveOrUpdate(t);
				systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
			} catch(Exception e){
				e.printStackTrace();
				message = "奖品记录更新失败";
				}
			} else{
				message = "奖品记录添加成功";
				awardService.save(award);
				systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
			}
			j.setMsg(message);
			return j;
	}	
	
	@RequestMapping(params = "addOrUpdate")
	public ModelAndView addOrUpdate(AwardEntity award, HttpServletRequest request){
		if(StringUtil.isNotEmpty(award.getId())){
			award = systemService.getEntity(AwardEntity.class, award.getId());
			request.setAttribute("awardPage",award);
		}
		return new ModelAndView("weixin/idea/award/award/award");
	}
}
