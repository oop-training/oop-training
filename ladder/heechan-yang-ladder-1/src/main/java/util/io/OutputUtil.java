package util.io;

import vo.Person;

import java.util.List;

public interface OutputUtil {

    public void printResult(List<Person> people, String target);

    public void printAllResult(List<Person> people);

    public void printEachResult(Person target);

    public void printNoManExist();

    public enum OutputNoticeText {
        TEXT_OUTPUT_NOT_EXIST_PEOPLE("해당 이름을 가진 사람이 존재하지 않습니다");

        private String value;

        OutputNoticeText(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }
}
