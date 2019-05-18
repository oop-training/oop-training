package util.io;

import vo.Person;
import vo.Reward;
import java.util.List;

public interface InputUtil {

    public List<Person> inputPeople();

    public List<Reward> inputRewards();

    public int inputHeight();

    public String inputTarget();

    public enum InputNoticeText {
        TEXT_INPUT_PEOPLE("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"),
        TEXT_INPUT_RESULTS("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)"),
        TEXT_INPUT_HEIGHT("최대 사다리 높이는 몇 개인가요?"),
        TEXT_INPUT_TARGET("결과를 보고 싶은 사람은? (input 'exit' to exit)");

        private String value;

        InputNoticeText(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }
}
