package weixin.idea.award.service.impl;

import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import weixin.idea.award.service.AwardServiceI;

@Service("awardService")
@Transactional
public class AwardServiceImpl extends CommonServiceImpl implements AwardServiceI{

}
