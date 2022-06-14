public class Main {
    public static void main(String[] args) {
        Comment[] comments = new Comment[]{
                new Comment(5, "Take special care when molding"),
                new Comment(7, "Processes slowly"),
                new Comment(8, "Ask supervisor for further instructions"),
                new Comment(13, "Use Tool number 0815"),
                new Comment(14, "Special setup needed"),
                new Comment(16, "Deviations in drawings"),
                new Comment(20, "Customer specific definition"),
                new Comment(31, "Part broken"),
                new Comment(34, "Remeasurement needed"),
                new Comment(41, "Rush order"),
                new Comment(44, "Forging needs to be performed"),
                new Comment(47, "Use drawing V.1103"),
                new Comment(48, "Testing comments function"),

                //Test cases for different from provided data
                new Comment(1, "Testing comments function1"),
                new Comment(2, "Testing comments function2"),
                new Comment(3, "Testing comments function3"),
                new Comment(4, "Testing comments function4"),
                new Comment(6, "Testing comments function6"),
                new Comment(9, "Testing comments function9"),
                new Comment(10, "Testing comments function10"),
                new Comment(11, "Testing comments function11"),
                new Comment(12, "Testing comments function12"),
                new Comment(15, "Testing comments function15")
        };

        Part[] assembly = new Part[]{
                new Part(5, 0),
                new Part(7, 5),
                new Part(8, 7),
                new Part(13, 7),
                new Part(31, 5),
                new Part(47, 5),
                new Part(41, 20),
                new Part(20, 34),
                new Part(48, 34),
                new Part(34, 16),
                new Part(14, 44),
                new Part(16, 44),
                new Part(44, 0),

                //Test cases for different from provided data
                new Part(1, 0),
                new Part(2, 1),
                new Part(3, 2),
                new Part(4, 2),
                new Part(6, 2),
                new Part(9, 2),
                new Part(10, 6),
                new Part(11, 6),
                new Part(12, 6),
                new Part(15, 9),
        };

        /*EXPECTED:
            Input: 13
            Output:
            Main Part: 5
            Commnets:
            Take special care when molding
            Processes slowly
            Ask supervisor for further instructions
            Use Tool number 0815
            Part broken
            Use drawing V.1103
        */
        System.out.println(Logic.calcData(13, assembly, comments));

        /*EXPECTED:
            Input: 48
            Output:
            Main Part: 44
            Commnets:
            Special setup needed
            Deviations in drawings
            Customer specific definition
            Remeasurement needed
            Rush order
            Forging needs to be performed
            Testing comments function
        */
        System.out.println(Logic.calcData(48, assembly, comments));


        /*EXPECTED:
            Input: 12
            Output:
            Main Part: 1
            Commnets:
            Testing comments function1
            Testing comments function2
            Testing comments function3
            Testing comments function4
            Testing comments function6
            Testing comments function9
            Testing comments function10
            Testing comments function11
            Testing comments function12
            Testing comments function15
        */
        System.out.println(Logic.calcData(12, assembly, comments));

    }
}