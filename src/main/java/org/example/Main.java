package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(List.of(1, 1, 2, 3, 4, 4, 5, 5, 6, 7));
        System.out.println("Исходный массив задание 1: " + nums);
        System.out.println("Каждый 2 элемент задание 1: " + everyTwoElements(nums));
        System.out.println("Исходный массив задание 2: " + nums);
        System.out.println("Только четные и не повторяющиеся элементы задание 2: " + evenNumbersOnly(nums));
        String text = "Lorem Ipsum - это текст-\"рыба\", часто используемый в печати и вэб-дизайне. " +
                "Lorem Ipsum является стандартной \"рыбой\" для текстов на латинице с начала XVI века. " +
                "В то время некий безымянный печатник создал большую коллекцию размеров и форм шрифтов, " +
                "используя Lorem Ipsum для распечатки образцов. Lorem Ipsum не только успешно пережил без " +
                "заметных изменений пять веков, но и перешагнул в электронный дизайн. Его популяризации в " +
                "новое время послужили публикация листов Letraset с образцами Lorem Ipsum в 60-х годах и, " +
                "в более недавнее время, программы электронной вёрстки типа Aldus PageMaker, в шаблонах " +
                "которых используется Lorem Ipsum.";

        System.out.println("Повторяющиеся слова в строке: " + arrayDuplicateString(text));
        System.out.println("Повторяющиеся слова в строке с их количеством повторений: " + arrayDuplicate(text));
    }
    private static List everyTwoElements(ArrayList<Integer> nums){
        List<Integer> nums2 = new ArrayList<>();
        for(int i = 0; i < nums.size(); i++){
            if(i % 2 == 0){
                nums2.add(nums.get(i));
            }
        }
        return nums2;
    }
    private static List evenNumbersOnly(ArrayList<Integer> nums){
        ArrayList<Integer> nums2 = new ArrayList<>();
        for (Integer num : nums) {
            if (num % 2 == 0) {
                nums2.add(num);
            }
        }
        return clearDuplicate(nums2);
    }
    private static List clearDuplicate(ArrayList<Integer> nums){
        Set<Integer> set = new HashSet<>(nums);
        nums.clear();
        nums.addAll(set);
        return nums;
    }
    private static List clearDuplicateString(ArrayList<String> str){
        Set<String> set = new HashSet<>(str);
        str.clear();
        str.addAll(set);
        return str;
    }
    private static String arrayDuplicate(String str){
        Map<String, Integer> occurrences = new HashMap<String, Integer>();
        for ( String word : str.split(" ")) {
            Integer oldCount = occurrences.get(word);
            if ( oldCount == null ) {
                oldCount = 0;
            }
            occurrences.put(word, oldCount + 1);
        }
        return occurrences.toString();
    }
    private static String arrayDuplicateString(String str){
        Map<String, Integer> occurrences = new HashMap<String, Integer>();
        ArrayList<String> oc = new ArrayList<>();
        for ( String word : str.split(" ")) {
            Integer oldCount = occurrences.get(word);
            if ( oldCount == null ) {
                oldCount = 0;
            }
            occurrences.put(word, oldCount + 1);
            if(oldCount > 1){
                oc.add(word);
            }
        }
        return clearDuplicateString(oc).toString();
    }
}