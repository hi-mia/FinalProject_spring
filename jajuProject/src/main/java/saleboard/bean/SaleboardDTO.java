package saleboard.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class SaleboardDTO {
	private String sale_subject;
	private String sale_category;
	private String sale_content;
	private String sale_condition;
	private String sale_image1;
	private String sale_image2;
	private String sale_image3;
	private String sale_image4;
	private String sale_image5;
	private String sale_image6;
	private String sale_image7;
	private String sale_image8;
	private String sale_image9;
	private String sale_image10;
	private int sale_price;
	private String sale_nego;
	private String sale_direct;
	private String sale_delivery;
	private String sale_onlineTran;
	private String member_id;
	private String sale_state;
	private int sale_hit;
	private int sale_seq;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd")
	private Date sale_date;
	private String sale_hide;
	private String sale_buyer;
	private String member_sigungu;
	private double member_manner;
	private String member_image;
	private String member_sido;
	
	private int prev_num; //이전글 글번호
	private int next_num; //다음글 글번호
	private String prev_subject; //이전글 제목
	private String next_subject; //다음글 제목
}
