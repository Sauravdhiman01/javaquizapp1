import sys

def main():
    q_data = []

    # 1. Java Basics (20 questions)
    basics = [
        ("What does JVM stand for?", "Java Variable Machine", "Java Virtual Machine", "Java Verified Mode", "None", 1, "Easy", "Java Basics"),
        ("Which loop always executes at least once?", "while", "for", "do-while", "foreach", 2, "Easy", "Java Basics"),
        ("Which class is a wrapper for int?", "Int", "Integer", "intWrapper", "WrapInt", 1, "Easy", "Java Basics"),
        ("Which stream reads a file character by character?", "FileReader", "FileWriter", "Output", "Scanner", 0, "Medium", "Java Basics"),
        ("What is lambda in Java?", "Anonymous function", "Interface", "Class", "Constructor", 0, "Hard", "Java Basics"),
        ("Which of these is not a Java keyword?", "continue", "goto", "break", "throwing", 3, "Easy", "Java Basics"),
        ("Which operator checks equality?", "==", "=", "equals", "!=", 0, "Easy", "Java Basics"),
        ("What is the return type of main?", "void", "int", "String", "char", 0, "Easy", "Java Basics"),
        ("What is the default value of boolean?", "true", "0", "false", "null", 2, "Easy", "Java Basics"),
        ("How to create object in Java?", "new", "create", "make", "build", 0, "Easy", "Java Basics"),
        ("Which method reads input from user?", "next()", "read()", "input()", "scan()", 0, "Easy", "Java Basics"),
        ("Which class is used to format strings?", "Formatter", "String", "Builder", "Text", 0, "Medium", "Java Basics"),
        ("Which operator is used for logical AND?", "&&", "&", "||", "!", 0, "Easy", "Java Basics"),
        ("How many bits in a byte?", "8", "4", "16", "32", 0, "Easy", "Java Basics"),
        ("Which data type for true/false?", "boolean", "int", "byte", "float", 0, "Easy", "Java Basics"),
        ("Which class is used to write to file?", "FileWriter", "Scanner", "PrintReader", "Output", 0, "Medium", "Java Basics"),
        ("Which function to convert string to int?", "Integer.parseInt()", "parse()", "int()", "convert()", 0, "Easy", "Java Basics"),
        ("What is Java?", "Platform", "Language", "Technology", "All", 3, "Easy", "Java Basics"),
        ("How to stop loop in Java?", "exit", "break", "return", "stop", 1, "Easy", "Java Basics"),
        ("What is default int value?", "0", "null", "undefined", "-1", 0, "Easy", "Java Basics")
    ]
    q_data.extend(basics)

    # 2. OOP (20 questions)
    oop = [
        ("Which keyword is used to define a subclass?", "extends", "implements", "inherits", "final", 0, "Easy", "OOP"),
        ("Which is a superclass of all classes?", "Class", "Main", "Object", "Base", 2, "Easy", "OOP"),
        ("What is polymorphism?", "Multiple forms", "Multiple classes", "Many objects", "Code reuse", 0, "Medium", "OOP"),
        ("Which access modifier allows access from anywhere?", "private", "public", "protected", "default", 1, "Easy", "OOP"),
        ("What is inheritance?", "Code reuse", "Code hiding", "Code duplication", "None", 0, "Easy", "OOP"),
        ("Which keyword prevents override?", "private", "final", "static", "public", 1, "Medium", "OOP"),
        ("What is constructor?", "Special method", "Loop", "Class", "Static method", 0, "Easy", "OOP"),
        ("Which keyword is for interface implementation?", "inherit", "extends", "implements", "interface", 2, "Easy", "OOP"),
        ("What is abstract class?", "Can’t be instantiated", "Must override", "Both", "None", 0, "Medium", "OOP"),
        ("Which is not OOP concept?", "Encapsulation", "Abstraction", "Recursion", "Polymorphism", 2, "Easy", "OOP"),
        ("What does 'super' refer to?", "Parent class", "Child class", "Same class", "None", 0, "Medium", "OOP"),
        ("Which is for multiple inheritance?", "interface", "class", "extends", "None", 0, "Hard", "OOP"),
        ("What is Encapsulation?", "Wrapping data", "Hiding code", "Extending class", "None", 0, "Medium", "OOP"),
        ("Can we overload main method?", "Yes", "No", "Only in child", "Depends", 0, "Medium", "OOP"),
        ("Which keyword indicates a constant?", "const", "final", "static", "define", 1, "Easy", "OOP"),
        ("Can we instantiate an interface?", "Yes", "No", "Via class", "None", 1, "Easy", "OOP"),
        ("Does Java support multiple inheritance using classes?", "Yes", "No", "By default", "Depends", 1, "Easy", "OOP"),
        ("What is method overriding?", "Same name same params", "Same name different params", "Changing name", "None", 0, "Medium", "OOP"),
        ("What method compares objects?", "equals()", "==", "compareTo", "All", 0, "Medium", "OOP"),
        ("What is 'this' keyword?", "Current object", "Parent class", "Method name", "None", 0, "Easy", "OOP")
    ]
    q_data.extend(oop)

    # 3. Collections (20 questions)
    collections = [
        ("Which collection type does not allow duplicates?", "Set", "List", "ArrayList", "LinkedList", 0, "Medium", "Collections"),
        ("Which interface allows iteration?", "Iterator", "Iterable", "Collection", "List", 0, "Medium", "Collections"),
        ("Which type does not maintain insertion order?", "HashSet", "LinkedHashSet", "ArrayList", "Vector", 0, "Hard", "Collections"),
        ("Which stores key-value pairs?", "Map", "List", "Set", "Queue", 0, "Medium", "Collections"),
        ("Which collection maintains order?", "List", "Set", "Map", "Queue", 0, "Easy", "Collections"),
        ("Which class implements List?", "ArrayList", "HashSet", "TreeMap", "Date", 0, "Easy", "Collections"),
        ("What is faster for random access?", "ArrayList", "LinkedList", "Stack", "Queue", 0, "Medium", "Collections"),
        ("Which Map maintains insertion order?", "LinkedHashMap", "HashMap", "TreeMap", "Hashtable", 0, "Hard", "Collections"),
        ("Can a Set contain null?", "Yes", "No", "Only once", "Depends", 2, "Hard", "Collections"),
        ("Is Vector synchronized?", "Yes", "No", "Sometimes", "Never", 0, "Medium", "Collections"),
        ("Which collection uses FIFO?", "Queue", "Stack", "List", "Set", 0, "Easy", "Collections"),
        ("Which collection uses LIFO?", "Stack", "Queue", "List", "Set", 0, "Easy", "Collections"),
        ("Which Map sorts by keys?", "TreeMap", "HashMap", "LinkedHashMap", "ConcurrentHashMap", 0, "Medium", "Collections"),
        ("What is default capacity of ArrayList?", "10", "16", "20", "0", 0, "Hard", "Collections"),
        ("Which is a marker interface?", "Serializable", "Runnable", "Cloneable", "All of these", 3, "Medium", "Collections"),
        ("How to get collection size?", "size()", "length", "length()", "count", 0, "Easy", "Collections"),
        ("Which interface map implements?", "None", "Collection", "Iterable", "List", 0, "Hard", "Collections"),
        ("Can HashMap contain null keys?", "Yes", "No", "Throws exception", "Ignored", 0, "Medium", "Collections"),
        ("Is Hashtable synchronized?", "Yes", "No", "Depends", "None", 0, "Medium", "Collections"),
        ("Which loop is best for collections?", "foreach", "while", "do-while", "for", 0, "Easy", "Collections")
    ]
    q_data.extend(collections)

    # 4. Threads (20 questions)
    threads = [
        ("Which method starts a thread?", "start()", "run()", "execute()", "launch()", 0, "Medium", "Threads"),
        ("Which thread method causes the thread to sleep?", "wait", "sleep", "stop", "yield", 1, "Medium", "Threads"),
        ("What interface do threads implement?", "Runnable", "Threadable", "Callable", "Executor", 0, "Easy", "Threads"),
        ("Which keyword makes code thread-safe?", "synchronized", "volatile", "atomic", "lock", 0, "Medium", "Threads"),
        ("How to pause a thread explicitly?", "Thread.sleep()", "pause()", "stop()", "wait()", 0, "Easy", "Threads"),
        ("What is the max thread priority?", "10", "5", "1", "100", 0, "Hard", "Threads"),
        ("What is a daemon thread?", "Background thread", "Main thread", "Zombie thread", "Kernel thread", 0, "Medium", "Threads"),
        ("Can we call run() directly?", "Yes but no new thread", "No", "Syntax error", "Throws exception", 0, "Hard", "Threads"),
        ("Which method waits for thread death?", "join()", "wait()", "sleep()", "stop()", 0, "Medium", "Threads"),
        ("What exception does sleep throw?", "InterruptedException", "IOException", "ThreadException", "None", 0, "Medium", "Threads"),
        ("Can we restart a dead thread?", "No", "Yes", "Only daemon", "Depends", 0, "Medium", "Threads"),
        ("Which state is thread in after new?", "Runnable", "Running", "Waiting", "Dead", 0, "Easy", "Threads"),
        ("Who manages thread scheduling?", "JVM", "OS", "Thread class", "User", 0, "Hard", "Threads"),
        ("What is deadlock?", "Two threads waiting foreach other", "Thread crash", "Infinite loop", "None", 0, "Medium", "Threads"),
        ("Which method yields CPU?", "yield()", "sleep()", "wait()", "join()", 0, "Hard", "Threads"),
        ("Is volatile keyword for threads?", "Yes", "No", "It is for memory", "None", 0, "Medium", "Threads"),
        ("Which method belongs to Object class?", "wait()", "sleep()", "yield()", "join()", 0, "Hard", "Threads"),
        ("Does wait release locks?", "Yes", "No", "Sometimes", "Only static locks", 0, "Hard", "Threads"),
        ("Does sleep release locks?", "No", "Yes", "Sometimes", "Only static locks", 0, "Hard", "Threads"),
        ("How to create thread pool?", "Executors", "ThreadPool", "ThreadCreator", "None", 0, "Medium", "Threads")
    ]
    q_data.extend(threads)

    # 5. Exception Handling (20 questions)
    exceptions = [
        ("Which block always executes irrespective of exceptions?", "catch", "try", "finally", "throw", 2, "Easy", "Exception Handling"),
        ("Which exception represents a null reference?", "IOException", "NullPointerException", "ClassNotFoundException", "FileException", 1, "Easy", "Exception Handling"),
        ("Which is used to handle exceptions?", "try-catch", "for-loop", "scanner", "handler", 0, "Easy", "Exception Handling"),
        ("How to handle runtime error?", "try-catch", "throw", "final", "catch", 0, "Easy", "Exception Handling"),
        ("Which keyword is used to throw exception manually?", "throw", "throws", "catch", "try", 0, "Medium", "Exception Handling"),
        ("Which keyword declares exception in method signature?", "throws", "throw", "finally", "catch", 0, "Medium", "Exception Handling"),
        ("What is superclass of exceptions?", "Throwable", "Exception", "Error", "Object", 0, "Hard", "Exception Handling"),
        ("Is RuntimeException checked or unchecked?", "Unchecked", "Checked", "Both", "None", 0, "Medium", "Exception Handling"),
        ("Is IOException checked or unchecked?", "Checked", "Unchecked", "Both", "None", 0, "Medium", "Exception Handling"),
        ("Can we have multiple catch blocks?", "Yes", "No", "Only 2", "Limited", 0, "Easy", "Exception Handling"),
        ("Must finally block always be present?", "No", "Yes", "Only with try", "None", 0, "Easy", "Exception Handling"),
        ("What if try has return statement?", "finally still executes", "finally skipped", "Compiler error", "None", 0, "Hard", "Exception Handling"),
        ("Can we catch Error?", "Yes but bad practice", "No", "Compiler error", "None", 0, "Medium", "Exception Handling"),
        ("What is ClassNotFoundException?", "Checked", "Unchecked", "Error", "None", 0, "Medium", "Exception Handling"),
        ("Which exception is thrown by division by zero?", "ArithmeticException", "MathException", "DivisionException", "NumberFormatException", 0, "Easy", "Exception Handling"),
        ("What converts string format exceptions?", "NumberFormatException", "ParseException", "StringException", "None", 0, "Medium", "Exception Handling"),
        ("Can we nest try blocks?", "Yes", "No", "Only twice", "None", 0, "Medium", "Exception Handling"),
        ("Method overriding allows adding new checked exceptions?", "No", "Yes", "Only same", "None", 0, "Hard", "Exception Handling"),
        ("Method overriding allows new unchecked exceptions?", "Yes", "No", "Only same", "None", 0, "Hard", "Exception Handling"),
        ("What does getMessage() do?", "Returns detail message", "Prints trace", "Returns error code", "None", 0, "Medium", "Exception Handling")
    ]
    q_data.extend(exceptions)

    with open('data/questions.txt', 'w') as f:
        for q in q_data:
            # format: question|opt1|opt2|opt3|opt4|correctIndex|difficulty|category
            line = f"{q[0]}|{q[1]}|{q[2]}|{q[3]}|{q[4]}|{q[5]}|{q[6]}|{q[7]}\n"
            f.write(line)

if __name__ == '__main__':
    main()
