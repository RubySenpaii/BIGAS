package objects;

/**
 * Created by Josiah on 27/10/2016.
 */

public class ProgramSurvey {

    public static final String TABLE_NAME = "ProgramSurvey";
    public static final String COLUMN_PROGRAM_ID ="ProgramID";
    public static final String COLUMN_QUESTION_NO = "QuestionNo";
    public static final String COLUMN_TYPE = "Type";
    public static final String COLUMN_QUESTION = "Question";

    private int programID;
    private int questionNo;
    private String type; //to determine whether the farmer rates or provides comments/suggestions
    private String question;

    public ProgramSurvey() {
    }

    public ProgramSurvey(int programID, int questionNo, String type, String question) {
        this.programID = programID;
        this.questionNo = questionNo;
        this.type = type;
        this.question = question;
    }

    public int getProgramID() {
        return programID;
    }

    public void setProgramID(int programID) {
        this.programID = programID;
    }

    public int getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
