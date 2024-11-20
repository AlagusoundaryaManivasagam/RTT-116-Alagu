package M303_12;

public class ExceptionExample {
    public static void main(String[] args){
        int[] numbers = {1,2,3,4,5,6,7};
        /*try{
            System.out.println(numbers[10]);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("==============> "+ e.getMessage());
        }finally {
            //this code executes no matter what whether its a success or failure
            // this is optional
            // often its used to cleanup or close a resource
            System.out.println("=======finally========");
        }
        try{
            System.out.println(numbers[1]);
        }catch (Exception e){
            System.out.println("==============> "+ e.getMessage());
        }finally {
            //this code executes no matter what whether its a success or failure
            // this is optional
            // often its used to cleanup or close a resource
            // using this should be justified

            System.out.println("=======finally========");
        }
        // you can type rest of code here
        try{
            System.out.println(numbers[10]);
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println("==============> "+ e.getMessage());
        }finally {
            //this code executes no matter what whether its a success or failure
            // this is optional
            // often its used to cleanup or close a resource
            System.out.println("=======finally========");
        }
        try{
           int x =10/0;
        }catch (ArithmeticException e){
            e.printStackTrace();
            System.out.println("==============> "+ e.getMessage());
        }finally {
            //this code executes no matter what whether its a success or failure
            // this is optional
            // often its used to cleanup or close a resource
            System.out.println("=======finally========");
        }
        try{
            int x =10/0;
        }catch (Exception e){
            System.out.println("==============> "+ e.getMessage());
        }finally {
            //this code executes no matter what whether its a success or failure
            // this is optional
            // often its used to cleanup or close a resource
            System.out.println("=======finally========");
        }*/
        try{
            //array out of index exception
            //System.out.println(numbers[10]);
            //string out of bound exception
            //String s1 = "abc";
            //s1.charAt(10);
            // null pointer exception
            String s2 = null;
            s2.toUpperCase();

            System.out.println("last line of try block and works only if try block is right");
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        /*catch(NullPointerException e){
            System.out.println(" hey I'm a null pointer exception");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }*/
        catch (Exception e){
            System.out.println("hey I'm a exception e");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        finally {
            System.out.println("===========finally=======");
        }
    }
}
