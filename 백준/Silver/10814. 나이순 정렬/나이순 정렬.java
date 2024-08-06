import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Person[] person = new Person[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            person[i] = new Person(i, age, name);
        }

        Arrays.sort(person, (o1, o2) -> {
            if (o1.getAge() == o2.getAge()) {
                return o1.getIndex() - o2.getIndex();
            }

            return o1.getAge() - o2.getAge();
        });

        StringBuilder answer = new StringBuilder();
        for (Person p : person) {
            answer.append(p.getAge()).append(" ").append(p.getName()).append("\n");
        }

        System.out.println(answer);
    }

    static class Person {
        private int index;
        private int age;
        private String name;

        public Person(int index, int age, String name) {
            this.index = index;
            this.age = age;
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
