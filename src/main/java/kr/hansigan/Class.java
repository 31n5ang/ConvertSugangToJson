package kr.hansigan;

import java.util.List;

public class Class {
    private Integer no; //No.
    private String code; //과목코드
    private String title; //교과목명
    private String part; //분반
    private String classification; //대표이수구분
    private Integer hak; //학점
    private Integer gang; //강의
    private Integer sil; //실습
    private Integer seol; //설계
    private String department; //개설학부(과)
    private Integer grade; //학년
    private String prof; //담당교수
    private Integer capacity; //수강정원
    private List<String> time; //강의시간
    private List<String> pgrade; //수강신청가능학년
    private Boolean isGradeLimit; //학과,학년제한적용
    private String evaluation; //성적평가
    private Boolean isEnglish; //영어강의

    public Class(Integer no, String code, String title, String part, String classification,
                 Integer hak, Integer gang, Integer sil, Integer seol, String department,
                 Integer grade, String prof, Integer capacity, List<String> time, List<String> pgrade,
                 Boolean isGradeLimit, String evaluation, Boolean isEnglish) {
        this.no = no;
        this.code = code;
        this.title = title;
        this.part = part;
        this.classification = classification;
        this.hak = hak;
        this.gang = gang;
        this.sil = sil;
        this.seol = seol;
        this.department = department;
        this.grade = grade;
        this.prof = prof;
        this.capacity = capacity;
        this.time = time;
        this.pgrade = pgrade;
        this.isGradeLimit = isGradeLimit;
        this.evaluation = evaluation;
        this.isEnglish = isEnglish;
    }

    //String -> Class
    public Class(List<String> tmp) {
        int idx = 0;
        this.no = tmp.get(idx++).charAt(0) - '0';
        this.code = tmp.get(idx++);
        this.title = tmp.get(idx++);
        this.part = tmp.get(idx++);
        this.classification = tmp.get(idx++);
        this.hak = tmp.get(idx++).charAt(0) - '0';
        this.gang = tmp.get(idx++).charAt(0) - '0';
        this.sil = tmp.get(idx++).charAt(0) - '0';
        this.seol = tmp.get(idx++).charAt(0) - '0';
        this.department = tmp.get(idx++);
        this.grade = tmp.get(idx++).charAt(0) - '0';
        this.prof = tmp.get(idx++).equals("false") ? "" : tmp.get(11);
        this.capacity = tmp.get(idx++).charAt(0) - '0';
        this.time = convertString2List(tmp.get(idx++));
        this.pgrade = convertString2List(tmp.get(idx++));
        this.isGradeLimit = tmp.get(idx++).charAt(0) - '0' != 0;
        this.evaluation = tmp.get(idx++);
        this.isEnglish = tmp.get(idx++).charAt(0) - '0' != 0;
    }

    static List<String> convertString2List(String time) {
        String[] times = time.split(",");
        return List.of(times);
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public Integer getHak() {
        return hak;
    }

    public void setHak(Integer hak) {
        this.hak = hak;
    }

    public Integer getGang() {
        return gang;
    }

    public void setGang(Integer gang) {
        this.gang = gang;
    }

    public Integer getSil() {
        return sil;
    }

    public void setSil(Integer sil) {
        this.sil = sil;
    }

    public Integer getSeol() {
        return seol;
    }

    public void setSeol(Integer seol) {
        this.seol = seol;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public List<String> getTime() {
        return time;
    }

    public void setTime(List<String> time) {
        this.time = time;
    }

    public List<String> getPgrade() {
        return pgrade;
    }

    public void setPgrade(List<String> pgrade) {
        this.pgrade = pgrade;
    }

    public Boolean getGradeLimit() {
        return isGradeLimit;
    }

    public void setGradeLimit(Boolean gradeLimit) {
        isGradeLimit = gradeLimit;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public Boolean getEnglish() {
        return isEnglish;
    }

    public void setEnglish(Boolean english) {
        isEnglish = english;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("[");
        ret.append(no).append(", ");
        ret.append(code).append(", ");
        ret.append(title).append(", ");
        ret.append(part).append(", ");
        ret.append(classification).append(", ");
        ret.append(hak).append(", ");
        ret.append(gang).append(", ");
        ret.append(sil).append(", ");
        ret.append(seol).append(", ");
        ret.append(department).append(", ");
        ret.append(grade).append(", ");
        ret.append(prof).append(", ");
        ret.append(capacity).append(", ");
        ret.append(time).append(", ");
        ret.append(pgrade).append(", ");
        ret.append(isGradeLimit).append(", ");
        ret.append(evaluation).append(", ");
        ret.append(isEnglish);
        ret.append("]");
        return ret.toString();
    }
}
