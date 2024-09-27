package org.example;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;


public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Метод возвращает подстроку максимальной длины в которой не повторяются символы
     * Если найдено несколько подстрок одинаковой длины - вернуть первую.
     *
     * Пример 1 вход= abcddcba, выход = abcd
     * Так как найдены две подстроки с неповторяющимися значениями:
     * 1) abcd
     * 2) dcba
     * Они динаковой длины, по этому возвращаем 1 строку
     *
     * Пример 2 вход= abcddcbaX, выход = dcbaX
     * Так как эта подстрока самая большая
     *
     * @param str входная не пустая строка
     * @return максимальная подстрока из уникальных значений
     * Сигнатуру метода не меняем
     */
    public String findMaxSubstring(String str) {
        String result = "";
        var set = new LinkedHashSet<String>();
        for (int i = 0; i < str.length(); i++) {
            var c = String.valueOf(str.charAt(i));
            if (!set.add(c)) {
                result = maxSize(result, set);
                set.clear();
                set.add(c);
            }
        }
        return maxSize(result, set);
    }

    private String maxSize(String s1, Set<String> s2) {
        if (s2.size() > s1.length()) {
            return String.join("", s2);
        }
        return s1;
    }

    /**
     * Задача со зведочкой (опционально)
     * <br/>
     * Можно решать так же для английского алфавита, проверять что присутствуют буквы от A до Z хотя бы по одному разу.
     * <br/>
     * A pangram is a sentence that contains every single letter of the alphabet at least once. For example, the sentence "The quick brown fox jumps over the lazy dog" is a pangram, because it uses the letters A-Z at least once (case is irrelevant).
     *
     * Given a string, detect whether or not it is a pangram. Return True if it is, False if not. Ignore numbers and punctuation.
     * @see <a href="https://www.codewars.com/kata/545cedaa9943f7fe7b000048">https://www.codewars.com/kata/545cedaa9943f7fe7b000048</a>
     */
    public boolean check(String sentence){
        var set = sentence.toLowerCase().chars().boxed().collect(Collectors.toSet());
        for (int i = 'a'; i <= 'z'; i++) {
            if (set.add(i)) {
                return false;
            }
        }
        return true;
    }

}
