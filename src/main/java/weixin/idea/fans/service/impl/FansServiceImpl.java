package weixin.idea.fans.service.impl;

import java.io.Serializable;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.guanjia.account.service.WeixinAccountServiceI;
import weixin.idea.fans.entity.FansEntity;
import weixin.idea.fans.service.FansServiceI;

@Service("fansService")
@Transactional
public class FansServiceImpl extends CommonServiceImpl implements FansServiceI{
	
	@Autowired
	private WeixinAccountServiceI weixinAccountService;
	
	@Override
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((FansEntity)entity);
 	}
 	@Override
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((FansEntity)entity);
 		return t;
 	}
 	@Override
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((FansEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
	public boolean doAddSql(FansEntity t) {
		return false;
	}

	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
	public boolean doUpdateSql(FansEntity t) {
		return false;
	}

	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
	public boolean doDelSql(FansEntity t) {
		return false;
	}
	
	

}
