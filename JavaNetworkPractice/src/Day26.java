public class Day26 {
        private String secret = "비공개.캡슐화된 변수";
        String s = "외부";

        class MemberClass {
            String s = "내부";

            public void show1() {
                System.out.println("내부 클래스");
                System.out.println(secret); // MemberClass 안에 servre 변수가 존재하지 않아 바로 바깥에 존재함.

                System.out.println(s);

                System.out.println(Day26.this.s);
            }

             static String s3 = "정적 멤버 필드";
             static void show2() {}
        }

        public static void main(String[] args) {
            Day26 m = new Day26();
            Day26.MemberClass m1 = m.new MemberClass();

            System.out.println(m1.s);
            m1.show1();

            System.out.println(m.s); // Memberclass의 인스턴스 변수

//            System.out.println(m.s3); // Memberclass의 인스턴스 변수
                // member 클래스에는 직접 접근할 수 없다. 멤버클래스 자체로 접근하거나
                // 외부클래스.내부클래스.변수or메소드 이렇게 접근해야 한다.


        }
    }

