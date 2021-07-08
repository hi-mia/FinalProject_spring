package question.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class QuestionDTO {
	private int question_seq;
	private String question_subject;
	private String question_content;
	private String questionType;
	private String question_image1;
	private String question_image2;
	private String question_image3;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy.MM.dd")
	private Date logtime;
}
