public class InvalidBadgeRecords {
    public static String[] invalidBadge(String[][] records) {
        if (records == null || records.length == 0 || records[0].length == 0)
            return new String[0];
        
        List<String> resultList = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (String[] record : records) {
            if (record[1].equals("enter")) {
                if (set.contains(record[0])) {
                	resultList.add(record[0]);
                } else {
                    set.add(record[0]);
                }
            }
            if (record[1] == "exit") {
                if (!set.contains(record[0])) {
                	resultList.add(record[0]);
                } else {
                    set.remove(record[0]);
                }
            }
        }

        for (String name : set) {
            if (!resultList.contains(name)) {
            	resultList.add(name);
            }
        }

        String[] resultArr = new String[resultList.size()];
        int index = 0;
        for (String s : resultList) {
            resultArr[index] = s;
            index++;
        }
        return resultArr;
    }

    public static void main(String[] args) {
        String[][] input = {{"Mario",   "exit"},
                            {"John",    "enter"},
                            {"Mario",   "enter"},
                            {"Mario",   "exit"},
                            {"Chris",   "enter"},
                            {"John",    "enter"},
                            {"Jane",    "enter"},
                            {"John",    "exit"},
                            {"Mario",   "enter"},
                            {"Mario",   "exit"},
                            {"Chris",   "exit"}};

        String[] output = invalidBadge(input);
        System.out.println(Arrays.toString(output));
    }
}