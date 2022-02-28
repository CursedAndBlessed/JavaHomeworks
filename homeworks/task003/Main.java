import java.util.*;


public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList(Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4));
        ArrayList<Integer> sortedList = new ArrayList<>();

        for (int i = 0; i < list.size() ; i++) {
            if (list.get(i) % 2 == 0 && list.get(i) > 0) {
                sortedList.add(list.get(i));
            }
        }
        Collections.sort(sortedList);
        System.out.println("Итог с помощью коллекций: " + sortedList);
        ArrayList<Integer> listAPI = (ArrayList<Integer>) StreamMain.getMyStream(list);
        System.out.println("Итоге с помощью Stream API " + listAPI);





        }





    }

