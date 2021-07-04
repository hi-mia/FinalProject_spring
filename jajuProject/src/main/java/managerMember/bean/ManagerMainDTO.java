package managerMember.bean;

import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@Data
public class ManagerMainDTO {

	private String sale_category;
	private int countCategory;
	
	private int dd1,dd2,dd3,dd4,dd5,dd6,dd7;
	private String d1, d2, d3, d4, d5, d6, d7;
	
	private String Most_Regist;
	private int count;
	
}
