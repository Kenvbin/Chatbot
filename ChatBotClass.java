import java.util.Arrays;

class ChatBotClass {

  private static String[] keywordTypes = { "family", "pets", "hobbies", "married", "sports", "travel", "job", "tv", "hi", "want", "like", "love"};

  private static String[] unknownResponse = {
    "Tell me more", "Wow, go on!", "Keep going", "Alright...", "Yea, and",
    "That's interesting!", "I'd love to hear more", "Fascinating!", "Tell me your thoughts on that",
    "Interesting perspective", "What else can you share?", "I'm curious, tell me more",
    "I'm all ears!", "Go ahead, I'm listening", "Keep the details coming", "I'm intrigued!",
    "That's a unique perspective", "I'm here to learn, tell me more", "And then what happened?",
    "You've got my attention", "Sounds intriguing, tell me more"
};


private static String[][] allKeywords =
{
    { "brother ", "mother ", "father ", "sister ", "grandpa ", "grandma ", "mom ", "dad ",
        "family ", "relative ", "parent " }, // family

    { "cat ", "dog ", "fish ", "hamster ", "pet "}, // pet

    { "hobby ", "hobbies ", "pastime ", "interest ", "activity ", "passion ", "leisure " }, // hobbies

    { "wife ", "husband ", "married ", "spouse ", "marriage ", "matrimony ", "wedding "}, // married

    { "sport ", "sports ", "soccer ", "basketball ", "tennis ", "8ball ", "football ",
        "athletics ", "exercise ", "competition ", "game " }, // sports

    { "visit ", "visited ", "travel ", "traveled ", "journey ", "exploration ",
        "adventure ", "vacation ", "trip " }, // travel

    { "job ", "boss ", "work ", "office ", "career ", "employment ", "profession ", "occupation " }, // job

    { "tv ", "television ", "show ", "series ", "program ", "entertainment ", "episode " }, // tv

    { "hi ", "hello ", "greetings ", "hey ", "howdy ", "salutations ", "hola " }, // HI

    {"i want ", "desire ", "wish for ", "crave ", "long for ", "seek "}, // want

    {"i like "}, // like

    {"i love "}, // love
};


      private static String[][] allResponses =
      {
          { "Tell me more about your family.", "How is your family doing?",
              "What do you do for fun with your family?", "What's your favorite family tradition?" }, // family
  
          { "Tell me more about your pets.", "What is your favorite pet?",
              "How many pets do you have?", "What (is/are) your pet's name('s)?",
              "Have you ever had any unusual pets?" }, // pet
  
          { "Tell me more about your hobbies.", "What other hobbies do you have?",
              "When did this start being a hobby of yours?", "Do you have a favorite hobby?",
              "Have you ever tried turning a hobby into a career?" }, // hobbies
  
          { "How long have you been married?", "What's the secret to a successful marriage?",
              "Do you have any marriage advice?", "What's your favorite memory with your spouse?" }, // married
  
          { "What do you find entertaining about sports?", "Do you play any sports yourself?",
              "Who is your favorite athlete?", "What's your most memorable sports moment?",
              "How do you feel about sportsmanship?" }, // sports
  
          { "Do you like to travel often?", "What places do you like to travel to most?",
              "Do you like traveling for vacation?", "What's the most exciting place you've visited?",
              "Do you prefer solo travel or with companions?" }, // travel
  
          { "Do you like your job?", "Tell me more about your job", "Are you good at your job? ",
              "What's the most challenging part of your job?",
              "If you could have any job in the world, what would it be?" }, // job
  
          { "What TV shows do you like to watch?", "What is your favorite TV show?",
              "Do you watch a lot of TV?", "If you could be a character in any TV show, who would you be?",
              "What's your guilty pleasure TV show?" }, // tv
  
          { "Hello", "Hi", "How are you?", "Greetings!", "Hey there!" }, // HI
  
          {"Why do you want ", "What motivates you to want "}, // want
  
          {"Why do you like ", "What makes you like "}, // like
  
          {"Why do you love ", "What makes you love ", "Can you share a special memory of loving "} // love
      };
  


  private static boolean containsKeyword(String inputText, String[] keywords) // checks if string contains any keyword in
                                                                       // keywordtype
  {
    for (String keyword : keywords) {
      if (inputText.contains(keyword)) {
        return true;
      }
    }
    return false;
  }

  public static String Format(String text){
      String inputText = text.replaceAll("[^a-zA-Z0-9\\s]", ""); // removes special characters & spaces
      inputText += " ";
      inputText = inputText.toLowerCase();
      return inputText;
  }
  
  public static String detectKeyword(String text) // returns keyword type detected from text
  {
    String inputText = Format(text);
    for (int i = 0; i < keywordTypes.length; i++) // checks for keyword
    {
      if (containsKeyword(inputText, allKeywords[i])) {
        return keywordTypes[i];
      }
    }
    return "none";
  }

  public static String respondToKeyword(String text) // Finds text response based on keyword detected
  {
    String selectedKeyword = detectKeyword(text);
    int index = Arrays.asList(keywordTypes).indexOf(selectedKeyword);
    
    String inputText = Format(text);
    if (inputText.equals("bye ")||inputText.equals("goodbye ")) 
    {
      System.out.println("Goodbye!");
      System.exit(0);
      return "null";
    }

    else if (detectKeyword(text).equals("none")) 
    {
      return unknownResponse[(int) (Math.random() * unknownResponse.length)];
    } 
    
    else if (detectKeyword(text).equals("want")||detectKeyword(text).equals("like")||detectKeyword(text).equals("love")) 
    {
      
      
      if (inputText.contains("i want"))
      {
        inputText = inputText.replace("i want", "");
        String arr[] = inputText.split(" ", 2);
        return allResponses[index][(int) (Math.random() * allResponses[index].length)] + arr[1].substring(0, arr[1].length() - 1)+"?";
      }
      
      else if (inputText.contains("i like"))
      {
        inputText = inputText.replace("i like", "");
        String arr[] = inputText.split(" ", 2);
        return allResponses[index][(int) (Math.random() * allResponses[index].length)] + arr[1].substring(0, arr[1].length() - 1)+"?";
      }
      
      else
      {
        inputText = inputText.replace("i love", "");
        String arr[] = inputText.split(" ", 2);
        return allResponses[index][(int) (Math.random() * allResponses[index].length)] + arr[1].substring(0, arr[1].length() - 1)+"?";
      }
      
    }

    else 
    {
      return allResponses[index][(int) (Math.random() * allResponses[index].length)];
    }
  }
}