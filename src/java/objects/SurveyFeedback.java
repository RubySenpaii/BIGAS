package objects;

/**
 * Created by Josiah on 27/10/2016.
 */

public class SurveyFeedback {

    public static final String TABLE_NAME = "SurveyFeedback";
    public static final String COLUMN_QUESTION_NO = "QuestionNo";
    public static final String COLUMN_PROGRAM_ID = "ProgramID";
    public static final String COLUMN_VALUE = "Vaule";
    public static final String COLUMN_COMMENT = "Comment";

    private int questionNo;
    private int programID;
    private int value;
    private String comment;

    public SurveyFeedback() {
    }

    public SurveyFeedback(int questionNo, int programID, int value, String comment) {
        this.questionNo = questionNo;
        this.programID = programID;
        this.value = value;
        this.comment = comment;
    }

    public int getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }

    public int getProgramID() {
        return programID;
    }

    public void setProgramID(int programID) {
        this.programID = programID;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
