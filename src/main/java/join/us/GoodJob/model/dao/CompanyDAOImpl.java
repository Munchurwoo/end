package join.us.GoodJob.model.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyDAOImpl implements CompanyDAO {
	
	@Resource
	SqlSessionTemplate template;

}
