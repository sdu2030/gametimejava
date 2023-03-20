/**
* Name: Samuel Du
* Date: 1/28/2021
* Class: Period 4
*
* Description: The purpose of this program is to provide an arcade based experience with the console that meet the requirements stated in the project outline: https://docs.google.com/document/d/1Yvb8sKxUMXCjiEj2j3C1tTdxBAy3Mhnv7eFNhFsSsds/edit
*
* Some important things to note:
* The code "System.out.print("\033[H\033[2J");" was borrowed from a website that offered information for how to clear a console. I didn't want to keep pumping 100 empty lines into the console to clear it so I decided to just search for a command to clear the console properly.
*
* The code 'main(new String[1]);' was discovered through google a bit of time ago when I was looking for ways to implement recursion using the main method.
*
* MY EXTENTION IDEAS WERE IMPLEMENTED IN THE NUMBER GUESSER PROGRAM. 
* They include: 
* Display the guesses the user has made
* Don’t count guesses made outside the range
*/

import java.util.Scanner;
public class GameTimeSamuelD {
  //A simple, global variable to keep track of the amount of wins/useful information the user has:
  public static int wins = 0;
  public static int loss = 0;
  public static int Gs = 0;
//
  /**
  * The method 'getInput' was imported from my previous Mad Libs program to make life easier on myself.
  *
  * It recieves a string as it's input and displays the String while checking for input.
  */
  public static String getInput(String POS){
    Scanner in = new Scanner(System.in);
    System.out.println(POS);
    return in.nextLine();
  }
//
  /**
  * The method 'Selection' was created in order to orgnize all the method executing and screen clearing in the program. 
  *
  * I decided that the main method would only be used to house the simplest portions of the program, such as the title and option display.
  *
  * 'Selection' accepts a string input and directs it to the coordinated selection option. I decided to make it accept Strings and not ints so that if someone gave me an invalid input, I could just implement recursion to give them another chance instead of having my program nuked.
  */
  public static void Selection(String select){
    Scanner in = new Scanner(System.in);
    
    if (select.equals("1")){
      WordGuesser();
    }
    else if (select.equals("2")){
      NumberGuesser();
    }
    else if (select.equals("3")){
      MadLibs();
    }
    else if (select.equals("4")){
      // clears the console
      System.out.print("\033[H\033[2J");
      newline(0);
      System.out.println("Your Game Statistics:");
      newline(0);
      //displays how many wins/losses they have, how many times they guessed on Word Guesser.
      System.out.println("Number of wins: "+ GameTimeSamuelD.wins+"\nNumber of losses: "+GameTimeSamuelD.loss+"\nNumber of Guesses on Word Guesser: "+GameTimeSamuelD.Gs);
      

      System.out.println("\n\n\n\nPlease press <<Enter>> to return to the main menu.");
      String placeholder = in.nextLine();
      System.out.print("\033[H\033[2J");
      main(new String[1]);
      
    }
    else if (select.equals("5")){
      System.exit(0);
      
    }
    else{
      System.out.print("\033[H\033[2J");
      main(new String[1]);
      
    }
    
  }
//
  /**
  * The method WordGuesser runs the game mode "Word Guesser"
  * 
  * The user will first be prompted to select a difficulty, then directed to the game.
  *
  * While the game portion is running, users will be told if how close they are to the actual word, how many mistakes they have left before they lose, and if a guess is correct or not.
  *
  * Once they fully guess the entire word or lose, they will be congratulated or bullied for their performance. Then they will be given the ability to return back to the main menu.
  */
  public static void WordGuesser(){
    Scanner in = new Scanner(System.in);
    
    //I decided to go hard on WordGuesser so I looked up 1000 basic english words on Wikipedia and implemented the list of words they gave into my own program. I didn't want to only use 10 words or else the user might memorize them all. This is the link where I got the words from: https://simple.wikipedia.org/wiki/Wikipedia:List_of_1000_basic_words

    //This is the place where I got the idea from:      My brain
  //
    String[] words = {"a", "about", "above", "across", "act", "active", "activity", "add", "afraid", "after", "again", "age", "ago", "agree", "air", "all", "alone", "along", "already", "always", "am", "amount", "an", "and", "angry", "another", "answer", "any", "anyone", "anything", "anytime", "appear", "apple", "are", "area", "arm", "army", "around", "arrive", "art", "as", "ask", "at", "attack", "aunt", "autumn", "away", "baby", "back", "bad", "bag", "ball", "bank", "base", "basket", "bath", "be", "bean", "bear", "beautiful", "bed", "bedroom", "beer", "behave", "before", "begin", "behind", "bell", "below", "besides", "best", "better", "between", "big", "bird", "birth", "birthday", "bit", "bite", "black", "bleed", "block", "blood", "blow", "blue", "board", "boat", "body", "boil", "bone", "book", "border", "born", "borrow", "both", "bottle", "bottom", "bowl", "box", "boy", "branch", "brave", "bread", "break", "breakfast", "breathe", "bridge", "bright", "bring", "brother", "brown", "brush", "build", "burn", "business", "bus", "busy", "but", "buy", "by", "cake", "call", "can", "candle", "cap", "car", "card", "care", "careful", "careless", "carry", "case", "cat", "catch", "central", "century", "certain", "chair", "chance", "change", "chase", "cheap", "cheese", "chicken", "child", "children", "chocolate", "choice", "choose", "circle", "city", "class", "clever", "clean", "clear", "climb", "clock", "cloth", "clothes", "cloud", "cloudy", "close", "coffee", "coat", "coin", "cold", "collect", "color", "comb", "comfortable", "common", "compare", "come", "complete", "computer", "condition", "continue", "control", "cook", "cool", "copper", "corn", "corner", "correct", "cost", "contain", "count", "country", "course", "cover", "crash", "cross", "cry", "cup", "cupboard", "cut", "dance", "dangerous", "dark", "daughter", "day", "dead", "decide", "decrease", "deep", "deer", "depend", "desk", "destroy", "develop", "die", "different", "difficult", "dinner", "direction", "dirty", "discover", "dish", "do", "dog", "door", "double", "down", "draw", "dream", "dress", "drink", "drive", "drop", "dry", "duck", "dust", "duty", "each", "ear", "early", "earn", "earth", "east", "easy", "eat", "education", "effect", "egg", "eight", "either", "electric", "elephant", "else", "empty", "end", "enemy", "enjoy", "enough", "enter", "equal", "entrance", "escape", "even", "evening", "event", "ever", "every", "everyone", "exact", "everybody", "examination", "example", "except", "excited", "exercise", "expect", "expensive", "explain", "extremely", "eye", "face", "fact", "fail", "fall", "false", "family", "famous", "far", "farm", "father", "fast", "fat", "fault", "fear", "feed", "feel", "female", "fever", "few", "fight", "fill", "film", "find", "fine", "finger", "finish", "fire", "first", "fish", "fit", "five", "fix", "flag", "flat", "float", "floor", "flour", "flower", "fly", "fold", "food", "fool", "foot", "football", "for", "force", "foreign", "forest", "forget", "forgive", "fork", "form", "fox", "four", "free", "freedom", "freeze", "fresh", "friend", "friendly", "from", "front", "fruit", "full", "fun", "funny", "furniture", "further", "future", "game", "garden", "gate", "general", "gentleman", "get", "gift", "give", "glad", "glass", "go", "goat", "god", "gold", "good", "goodbye", "grandfather", "grandmother", "grass", "grave", "great", "green", "gray", "ground", "group", "grow", "gun", "hair", "half", "hall", "hammer", "hand", "happen", "happy", "hard", "hat", "hate", "have", "he", "head", "healthy", "hear", "heavy", "heart", "heaven", "height", "hello", "help", "hen", "her", "here", "hers", "hide", "high", "hill", "him", "his", "hit", "hobby", "hold", "hole", "holiday", "home", "hope", "horse", "hospital", "hot", "hotel", "house", "how", "hundred", "hungry", "hour", "hurry", "husband", "hurt", "ice", "idea", "if", "important", "in", "increase", "inside", "into", "introduce", "invent", "iron", "invite", "is", "island", "it", "its", "jelly", "job", "join", "juice", "jump", "just", "keep", "key", "kill", "kind", "king", "kitchen", "knee", "knife", "knock", "know", "ladder", "lady", "lamp", "land", "large", "last", "late", "lately", "laugh", "lazy", "lead", "leaf", "learn", "leave", "leg", "left", "lend", "length", "less", "lesson", "let", "letter", "library", "lie", "life", "light", "like", "lion", "lip", "list", "listen", "little", "live", "lock", "lonely", "long", "look", "lose", "lot", "love", "low", "lower", "luck", "machine", "main", "make", "male", "man", "many", "map", "mark", "market", "marry", "matter", "may", "me", "meal", "mean", "measure", "meat", "medicine", "meet", "member", "mention", "method", "middle", "milk", "million", "mind", "minute", "miss", "mistake", "mix", "model", "modern", "moment", "money", "monkey", "month", "moon", "more", "morning", "most", "mother", "mountain", "mouth", "move", "much", "music", "must", "my", "name", "narrow", "nation", "nature", "near", "nearly", "neck", "need", "needle", "neighbor", "neither", "net", "never", "new", "news", "newspaper", "next", "nice", "night", "nine", "no", "noble", "noise", "none", "nor", "north", "nose", "not", "nothing", "notice", "now", "number", "obey", "object", "ocean", "of", "off", "offer", "office", "often", "oil", "old", "on", "one", "only", "open", "opposite", "or", "orange", "order", "other", "our", "out", "outside", "over", "own", "page", "pain", "paint", "pair", "pan", "paper", "parent", "park", "part", "partner", "party", "pass", "past", "path", "pay", "peace", "pen", "pencil", "people", "pepper", "per", "perfect", "period", "person", "petrol", "photograph", "piano", "pick", "picture", "piece", "pig", "pin", "pink", "place", "plane", "plant", "plastic", "plate", "play", "please", "pleased", "plenty", "pocket", "point", "poison", "police", "polite", "pool", "poor", "popular", "position", "possible", "potato", "pour", "power", "present", "press", "pretty", "prevent", "price", "prince", "prison", "private", "prize", "probably", "problem", "produce", "promise", "proper", "protect", "provide", "public", "pull", "punish", "pupil", "push", "put", "queen", "question", "quick", "quiet", "quite", "radio", "rain", "rainy", "raise", "reach", "read", "ready", "real", "really", "receive", "record", "red", "remember", "remind", "remove", "rent", "repair", "repeat", "reply", "report", "rest", "restaurant", "result", "return", "rice", "rich", "ride", "right", "ring", "rise", "road", "rob", "rock", "room", "round", "rubber", "rude", "rule", "ruler", "run", "rush", "sad", "safe", "sail", "salt", "same", "sand", "save", "say", "school", "science", "scissors", "search", "seat", "second", "see", "seem", "sell", "send", "sentence", "serve", "seven", "several", "sex", "shade", "shadow", "shake", "shape", "share", "sharp", "she", "sheep", "sheet", "shelf", "shine", "ship", "shirt", "shoe", "shoot", "shop", "short", "should", "shoulder", "shout", "show", "sick", "side", "signal", "silence", "silly", "silver", "similar", "simple", "single", "since", "sing", "sink", "sister", "sit", "six", "size", "skill", "skin", "skirt", "sky", "sleep", "slip", "slow", "small", "smell", "smile", "smoke", "snow", "so", "soap", "sock", "soft", "some", "someone", "something", "sometimes", "son", "soon", "sorry", "sound", "soup", "south", "space", "speak", "special", "speed", "spell", "spend", "spoon", "sport", "spread", "spring", "square", "stamp", "stand", "star", "start", "station", "stay", "steal", "steam", "step", "still", "stomach", "stone", "stop", "store", "storm", "story", "strange", "street", "strong", "structure", "student", "study", "stupid", "subject", "substance", "successful", "such", "sudden", "sugar", "suitable", "summer", "sun", "sunny", "support", "sure", "surprise", "sweet", "swim", "sword", "table", "take", "talk", "tall", "taste", "taxi", "tea", "teach", "team", "tear", "telephone", "television", "tell", "ten", "tennis", "terrible", "test", "than", "that", "the", "their", "then", "there", "therefore", "these", "thick", "thin", "thing", "think", "third", "this", "though", "threat", "three", "tidy", "tie", "title", "to", "today", "toe", "together", "tomorrow", "tonight", "too", "tool", "tooth", "top", "total", "touch", "town", "train", "tram", "travel", "tree", "trouble", "true", "trust", "twice", "try", "turn", "type", "ugly", "uncle", "under", "understand", "unit", "until", "up", "use", "useful", "usual", "usually", "vegetable", "very", "village", "voice", "visit", "wait", "wake", "walk", "want", "warm", "was", "wash", "waste", "watch", "water", "way", "we", "weak", "wear", "weather", "wedding", "week", "weight", "welcome", "were", "well", "west", "wet", "what", "wheel", "when", "where", "which", "while", "white", "who", "why", "wide", "wife", "wild", "will", "win", "wind", "window", "wine", "winter", "wire", "wise", "wish", "with", "without", "woman", "wonder", "word", "work", "world", "worry", "yard", "yell", "yesterday", "yet", "you", "young", "your", "zero", "zoo","I"};
  //

    String wordToGuess = (words[(int)(Math.random()*(words.length) )]).toUpperCase();
    int numGesd = 0;
    String guess = "";
    String concealed = "";
    int maxGuesses = 20;
    String gListCorrect = "";

    String gListWrong = "";

    //Clears any previous console text to keep everything clean:
    System.out.print("\033[H\033[2J");

    newline(0);
    //Tells them what game they are in:
    System.out.println("Welcome to the Word Guesser game!");
    newline(0);
    System.out.println("What difficulty would you like to play on?\n  1. Easy (20 mistakes)\n  2. Medium (12 mistakes)\n  3. Hard(8 mistakes)");
    newline(2);
    int difficulty = in.nextInt();

    if (difficulty == 2){
      maxGuesses = 12;
    }
    else if (difficulty == 3){
      maxGuesses = 8;
    }

    for (int x = 0; x<wordToGuess.length(); x++){
      concealed = concealed + "?";
    }

    String placeholder = in.nextLine();
    
    boolean loser = false;

    while ((concealed.equals(wordToGuess) == false )&& maxGuesses > 0){
      System.out.print("\033[H\033[2J");

      loser = true;
      newline(0);
      System.out.println("Mistakes left: "+maxGuesses+"\nList of letters guessed correctly and incorrectly:\nCorrect: "+gListCorrect+"\nIncorrect: "+gListWrong);
      newline(0);

      System.out.println("I am thinking of a word... Can you guess what it is?");
      System.out.println("\nWord to guess: "+concealed);
      System.out.println("Guess a letter: ");
      guess = in.nextLine().toUpperCase();
    
      if (wordToGuess.indexOf(guess)>-1){
        //I learned how to use .split() and .join() when trying to turn a string into an array of letters instead of characters. I realized that .equals() and String[] did not work with the 'char' datatype so I turned to .split() instead. (since it outputs a list of strings instead of chars). I also originally tried to do an indexOf type replacement but it was extremely buggy and inefficient with my approach of the program. I researched ways to split a string into an array of Strings and put them back together. After doing some digging on Stack Overflow, I found incredibly valuable information that sated my appetite for a better .toCharArray() method and put it to good use. I decided that this was the best approach since it was simple and similar to .toCharArray() method.
        
        String[] list2 = concealed.split("");
        for (int x = 0; x<concealed.length(); x++){
          if (guess.equals(wordToGuess.substring(x,x+1))){
            list2[x] = wordToGuess.substring(x,x+1);
            concealed = String.join("",list2);
            loser = false;
          }
        }
      }      

      if (loser == true){
        maxGuesses = maxGuesses - 1;
        System.out.println(guess + " was not a correct guess! Please try again.\nYou have "+maxGuesses+" mistakes left!");
        
        gListWrong = gListWrong+ guess+" ";
        
      }
      else {
        System.out.println(guess + " was a correct guess!");
        
        gListCorrect = gListCorrect+guess+" ";
      
      }

      System.out.println("\nPlease press <<Enter>> to continue.");
      numGesd = numGesd+1;
    newline(2);
    //placeholder lets them press <<Enter>> to get back to the menu
    placeholder = in.nextLine();
    }
    if (maxGuesses > 0){
    System.out.println("Congratulations! You have won! The correct word was "+wordToGuess+". \nIt only took you "+(numGesd-1)+" tries to get the correct answer!\n\nPlease press <<Enter>> to return to the main menu.");
    GameTimeSamuelD.wins = GameTimeSamuelD.wins + 1;
    }
    else{
      System.out.println("Boo! You have lost! The correct word was "+wordToGuess+". \nIt took you "+(numGesd-1)+" tries and you still got it wrong?!\nYou should feel ashamed of yourself. Do better next time!\n\nPlease press <<Enter>> to return to the main menu.");
      GameTimeSamuelD.loss = GameTimeSamuelD.loss + 1;
    }
    GameTimeSamuelD.Gs = Gs + numGesd;
    newline(2);
    //placeholder lets them press <<Enter>> to get back to the menu
    placeholder = in.nextLine();
    //clears any previous junk:
    
    System.out.print("\033[H\033[2J");
    main(new String[1]);
  }
//

  /**
  * The method NumberGuesser runs the game mode "Number Guesser"
  * 
  * The user will first be prompted to give a high and low limit for their target number before being directed to the actual game.
  *
  * While the game portion is running, users will be told if their guesses are incorrect, too high, or too low.
  *
  * Once they guess the correct, number they will be informed and given the option to return to the main menu.
  */
  public static void NumberGuesser(){
    Scanner in = new Scanner(System.in);
    String gListHigh = "";
    String gListLow = "";
    int guess;

    //Clears any previous console text to keep everything clean:
    System.out.print("\033[H\033[2J");

    newline(0);
    int numToGuess;
    //Tells them what game they are in:
    System.out.println("Welcome to the Number Guesser game!");
    newline(0);

    //Gives them the option to set the number limit
    System.out.println("Between which numbers would you like to guess?\nLowest number: ");
    int lown = in.nextInt();
    System.out.println("Highest number:");
    int highn = in.nextInt();

    System.out.println("\n\nPress <<Enter>> to start the game!");
    newline(2);
    String placeholder = in.nextLine();
    //Generates the random number to guess.
    numToGuess = (int)(Math.random()*(highn - lown) + lown);
    System.out.print("\033[H\033[2J");

    //Starts the game
    //'numGesd' keeps track of how many guesses they have done
    int numGesd = 1;
    //while loop keeps running until they guess the right number
    boolean loop = false;
    newline(0);
    System.out.println("Number Guesser!\nNumbers Guessed high: "+gListHigh+"\nNumbers Guessed low: "+gListLow);
    newline(0);
    System.out.println("Guess a number between "+highn+" and "+lown+":");
    guess = in.nextInt();

    while (guess != numToGuess){
      if (numGesd > 1 || loop == true){
        System.out.print("\033[H\033[2J");
        newline(0);
        System.out.println("Number Guesser!\nNumbers Guessed high: "+gListHigh+"\nNumbers Guessed low: "+gListLow);
        newline(0);
        System.out.println("Guess a number between "+lown+" and "+highn+":");
        guess = in.nextInt();
      }
      
      if ((guess > highn) || (guess < lown)){
        //Doesn't add to the guess counter if they guess out of bounds
        System.out.println("You have guessed out of bounds!\nPlease try again.\n\nPress <<Enter>> to continue.");
        newline(2);
        placeholder = in.nextLine();
        placeholder = in.nextLine();
        loop = true;
      }
      else if (guess > numToGuess){
        //tells them they guessed too high
        System.out.println("You have guessed too high! You have guessed "+numGesd+" times!\nPlease try again.\n\nPress <<Enter>> to continue.");
        newline(2);
        gListHigh = gListHigh+guess+" ";
        numGesd = numGesd+1;
        placeholder = in.nextLine();
        placeholder = in.nextLine();        
      }
      else if (guess < numToGuess){
        //tells them they guessed too low
        System.out.println("You have guessed too low! You have guessed "+numGesd+" times!\nPlease try again.\n\nPress <<Enter>> to continue.");
        newline(2);
        gListLow = gListLow+guess+" ";
        numGesd = numGesd+1;
        placeholder = in.nextLine();
        placeholder = in.nextLine();
      }

    }
  
    System.out.print("\033[H\033[2J");
    //tells them they have won
    System.out.println("Congratulations! You have won! The correct number was "+numToGuess+". \nIt only took you "+(numGesd)+" guesses to get the correct answer!\n\nPlease press <<Enter>> to return to the main menu.");

    newline(2);
    //placeholder lets them press <<Enter>> to get back to the menu
    placeholder = in.nextLine();
    placeholder = in.nextLine();
    //clears any previous junk:
    GameTimeSamuelD.wins = GameTimeSamuelD.wins + 1;
    System.out.print("\033[H\033[2J");
    main(new String[1]);
   
  }
//
  /**
  * The method MadLibs runs the game mode "Mad Libs"
  * 
  * The user will first be debreifed on the type and rules of the game, then be prompted to enter parts of speech in order to complete a short story.
  *
  * After they have entered all the required parts of speech, a short, funny story will be displayed based on their input.
  *
  * Once they finish the game, they will be given the option to return back to the main menu.
  */
  public static void MadLibs(){
    Scanner in = new Scanner(System.in);
    System.out.print("\033[H\033[2J");
    newline(0);
    System.out.println("Welcome to Mad Libs!");
    newline(0);

    System.out.println("In a moment you will be prompted to enter 14 parts of speech in order to complete a short story.\nPlease press <<Enter>> to continue.");
    newline(2);
    String placeholder = in.nextLine();

    String[] ml = new String[14];
    ml[0] = getInput("(verb, past tense):");
    ml[1] = getInput("(verb, past tense):");
    ml[2] = getInput("(verb, past tense):");
    ml[3] = getInput("(noun):");
    ml[4] = getInput("(adjective):");
    ml[5] = getInput("(noun; body part):");
    ml[6] = getInput("(verb, past tense):");
    ml[7] = getInput("(adjective):");
    ml[8] = getInput("(proper noun):");
    ml[9] = getInput("(verb, infinitive):");
    ml[10] = getInput("(noun, something):");
    ml[11] = getInput("(a time; tommrow, right now, etc.):");
    ml[12] = getInput("(number):");
    ml[13] = getInput("(adjective):");

    String theStory = String.format("\nToday I woke up and %s. I first %s my breakfast and then %s my %s. Then I brushed my %s %s and %s onto my programming class. We had to take a quiz and it was very %s. %s said that after the quiz we had %s a %s. That is what I am doing %s. I hope that I get a %s on this quiz because I want to be %s.", ml[0],ml[1],ml[2],ml[3],ml[4],ml[5],ml[6],ml[7],ml[8],ml[9],ml[10],ml[11],ml[12],ml[13]);

    System.out.println(theStory);

    System.out.println("\n\nI hope you laughed! I sure did!\n\nPlease press <<Enter>> to return to the main menu.");

    newline(2);
    //placeholder lets them press <<Enter>> to get back to the menu
    placeholder = in.nextLine();
    //clears any previous junk:
    GameTimeSamuelD.wins = GameTimeSamuelD.wins + 1;
    System.out.print("\033[H\033[2J");
    main(new String[1]);
  }
//
  /**
  * The method 'newline' helps me manage my laziness and improve it's appearance.
  * 
  * The only function of newline is to print different types of lines so that I do not have to. 
  *
  * I wasted my time by creating the second option since I never used it.
  *
  * It accepts an integer as input and then uses that integer to determine which type of line to print. 
  * 
  * Selections include: a normal line, a parallel line, a broken line, and no line.
  *
  */
  public static void newline(int type){
    if (type == 0){
      System.out.println("===================================================");
    }
    else if (type == 1){
      System.out.println("---------------------------------------------------");
    }
    else if (type == 2){
      System.out.println("___________________________________________________");
    }
    else {
      System.out.println("");
    }
  }
//
  
  /**
  * The main method houses the main menu. Hence the name: "main"
  *
  * It displays the title screen and possible selections for the program.
  *
  */
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    //displays ASCII art title text
    //Credits to: http://patorjk.com/
      newline(0);
      System.out.println("GAME TIME \nMade by: Sam Du");
      //added a small tag at the bottom of the title
      newline(0);
    //
    //Displays the menu selection:
    System.out.println("Please select a valid option:");

    //Lists out the valid options:
    System.out.println("  1. Word Guesser\n  2. Number Guesser\n  3. Mad Libs\n\n  4. Check your stats\n  5. Exit GameTime");
    newline(2);
    //The method 'Selection' determines what choice stands for what
    Selection(in.nextLine());
     
  }
}