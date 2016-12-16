package weixin.idea.fans.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.jeewx.api.core.exception.WexinReqException;
import org.jeewx.api.wxuser.user.JwUserAPI;
import org.jeewx.api.wxuser.user.model.Wxuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import weixin.guanjia.account.entity.WeixinAccountEntity;
import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.idea.fans.entity.FansEntity;

@Controller
@RequestMapping("/fansController")
public class FansController {

	private SystemService systemService;
	
	@Autowired
	private WeixinAccountServiceI weixinAccountService;
	
	@Resource(name="systemService")
    public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}
	
	@RequestMapping(params="list")
	public ModelAndView jumpList(){
		return new ModelAndView("weixin/idea/fans/fansList");
	}
	
	@RequestMapping(params = "datagrid")
	@ResponseBody
	public void datagrid(FansEntity fans,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
			
//		CriteriaQuery cq = new CriteriaQuery(FansEntity.class, dataGrid);
			
		WeixinAccountEntity weixinAccountEntity = this.weixinAccountService.findLoginWeixinAccount();
		if(weixinAccountEntity!=null){
			String accountId = weixinAccountEntity.getWeixin_accountid();
//			cq.eq("accountId", accountId);
		}
		//排序 
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("subscribetime", "desc");
//		cq.setOrder(map);
		//cq.add();
//		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, fans);
		//this.systemService.getDataGridReturn(cq, true);
		String next_openid = "";
		try {
			List<Wxuser> userList = JwUserAPI.getAllWxuser(weixinAccountEntity.getAccountaccesstoken(), null);
//			cq.getDataGrid().setResults(userList);
//			cq.getDataGrid().setTotal(userList.size());
			dataGrid.setResults(userList);
			dataGrid.setTotal(userList.size());
		} catch (WexinReqException e) {
			e.printStackTrace();
		}
		TagUtil.datagrid(response, dataGrid);
	}
}
