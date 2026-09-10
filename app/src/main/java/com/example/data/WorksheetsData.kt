package com.example.data

data class QuizQuestion(
    val id: String,
    val prompt: String,
    val transliterationClue: String,
    val emoji: String,
    val options: List<QuizOption>,
    val correctIndex: Int,
    val explanation: String
)

data class QuizOption(
    val script: String,
    val transliteration: String,
    val english: String
)

data class Worksheet(
    val id: String,
    val title: String,
    val cbseClass: Int,
    val topic: String,
    val icon: String,
    val description: String,
    val xpReward: Int,
    val questions: List<QuizQuestion>
)

object WorksheetsData {

    val worksheets: List<Worksheet> = listOf(
        Worksheet(
            id = "ws_c1_letters",
            title = "Class 1: First Akshar & Sounds",
            cbseClass = 1,
            topic = "Varnamala Basics",
            icon = "🔤",
            description = "Identify basic vowels and consonant sounds with English phonetic guides.",
            xpReward = 60,
            questions = listOf(
                QuizQuestion(
                    id = "q1_1",
                    prompt = "Which letter represents the sound 'aa' (like in 'father')?",
                    transliterationClue = "Look for the vowel that starts the word 'Aam' (Mango) / 'Aane' (Elephant).",
                    emoji = "🥭",
                    options = listOf(
                        QuizOption("अ / ಅ", "a", "short 'u'"),
                        QuizOption("आ / ಆ", "aa", "long 'aa'"),
                        QuizOption("इ / ಇ", "i", "short 'i'"),
                        QuizOption("उ / ಉ", "u", "short 'u'")
                    ),
                    correctIndex = 1,
                    explanation = "आ (Hindi) and ಆ (Kannada) represent the long 'aa' sound as in Aam (Mango) and Aane (Elephant)!"
                ),
                QuizQuestion(
                    id = "q1_2",
                    prompt = "Identify the word for 'Elephant' in Hindi and Kannada:",
                    transliterationClue = "Hindi: Haathi, Kannada: Aane",
                    emoji = "🐘",
                    options = listOf(
                        QuizOption("शेर / ಸಿಂಹ", "Sher / Simha", "Lion"),
                        QuizOption("हाथी / ಆನೆ", "Haathi / Aane", "Elephant"),
                        QuizOption("गाय / ಹಸು", "Gaay / Hasu", "Cow"),
                        QuizOption("मोर / ನವಿಲು", "Mor / Navilu", "Peacock")
                    ),
                    correctIndex = 1,
                    explanation = "Haathi (हाथी) in Hindi and Aane (ಆನೆ) in Kannada mean Elephant!"
                ),
                QuizQuestion(
                    id = "q1_3",
                    prompt = "How do you say 'Hello / Greetings' respectfully?",
                    transliterationClue = "Sounds like 'Namaste' in Hindi and 'Namaskaara' in Kannada.",
                    emoji = "🙏",
                    options = listOf(
                        QuizOption("नमस्ते / ನಮಸ್ಕಾರ", "Namaste / Namaskaara", "Hello"),
                        QuizOption("धन्यवाद / ಧನ್ಯವಾದ", "Dhanyavaad / Dhanyavaada", "Thank you"),
                        QuizOption("शुभ प्रभात / ಶುಭೋದಯ", "Shubh Prabhaat / Shubhrodaya", "Good morning"),
                        QuizOption("किताब / ಪುಸ್ತಕ", "Kitaab / Pusthaka", "Book")
                    ),
                    correctIndex = 0,
                    explanation = "Namaste (नमस्ते) and Namaskaara (ನಮಸ್ಕಾರ) are the standard respectful Indian greetings."
                ),
                QuizQuestion(
                    id = "q1_4",
                    prompt = "Which number is 'Two (2)'?",
                    transliterationClue = "Hindi: Do, Kannada: Eradu",
                    emoji = "2️⃣",
                    options = listOf(
                        QuizOption("एक / ಒಂದು", "Ek / Ondu", "One"),
                        QuizOption("दो / ಎರಡು", "Do / Eradu", "Two"),
                        QuizOption("तीन / ಮೂರು", "Teen / Mooru", "Three"),
                        QuizOption("चार / ನಾಲ್ಕು", "Chaar / Naalku", "Four")
                    ),
                    correctIndex = 1,
                    explanation = "Do (दो) in Hindi and Eradu (ಎರಡು) in Kannada mean Two!"
                )
            )
        ),

        Worksheet(
            id = "ws_c1_fruits",
            title = "Class 1: Sweet Fruits & Colors",
            cbseClass = 1,
            topic = "Fruits & Colors",
            icon = "🍎",
            description = "Match fruits, colors, and their English transliteration sounds.",
            xpReward = 60,
            questions = listOf(
                QuizQuestion(
                    id = "q2_1",
                    prompt = "What fruit is 'Aam' (Hindi) or 'Maavina Hannu' (Kannada)?",
                    transliterationClue = "The sweet yellow King of Fruits!",
                    emoji = "🥭",
                    options = listOf(
                        QuizOption("सेब / ಸೇಬು", "Seb / Sebu", "Apple"),
                        QuizOption("आम / ಮಾವಿನಹಣ್ಣು", "Aam / Maavina Hannu", "Mango"),
                        QuizOption("केला / ಬಾಳೆಹಣ್ಣು", "Kela / Baalehannu", "Banana"),
                        QuizOption("अंगूर / ದ್ರಾಕ್ಷಿ", "Angoor / Draakshi", "Grapes")
                    ),
                    correctIndex = 1,
                    explanation = "Aam (आम) and Maavina Hannu (ಮಾವಿನಹಣ್ಣು) mean Mango, India's national fruit!"
                ),
                QuizQuestion(
                    id = "q2_2",
                    prompt = "Which color is 'Laal' (Hindi) / 'Kempu' (Kannada)?",
                    transliterationClue = "The color of ripe strawberries, tomatoes, and roses!",
                    emoji = "🔴",
                    options = listOf(
                        QuizOption("नीला / ನೀಲಿ", "Neela / Neeli", "Blue"),
                        QuizOption("हरा / ಹಸಿರು", "Hara / Hasiru", "Green"),
                        QuizOption("लाल / ಕೆಂಪು", "Laal / Kempu", "Red"),
                        QuizOption("पीला / ಹಳದಿ", "Peela / Haladi", "Yellow")
                    ),
                    correctIndex = 2,
                    explanation = "Laal (लाल) in Hindi and Kempu (ಕೆಂಪು) in Kannada mean Red!"
                ),
                QuizQuestion(
                    id = "q2_3",
                    prompt = "What is the green color called?",
                    transliterationClue = "Hindi: Hara, Kannada: Hasiru",
                    emoji = "🟢",
                    options = listOf(
                        QuizOption("हरा / ಹಸಿರು", "Hara / Hasiru", "Green"),
                        QuizOption("सफेद / ಬಿಳಿ", "Safed / Bili", "White"),
                        QuizOption("काला / ಕಪ್ಪು", "Kaala / Kappu", "Black"),
                        QuizOption("पीला / ಹಳದಿ", "Peela / Haladi", "Yellow")
                    ),
                    correctIndex = 0,
                    explanation = "Hara (हरा) and Hasiru (ಹಸಿರು) mean Green like leaves and grass!"
                )
            )
        ),

        Worksheet(
            id = "ws_c2_school",
            title = "Class 2: School & Classroom",
            cbseClass = 2,
            topic = "School Life",
            icon = "🏫",
            description = "Learn classroom objects, friends, and everyday school vocabulary.",
            xpReward = 75,
            questions = listOf(
                QuizQuestion(
                    id = "q3_1",
                    prompt = "What do we call a 'Book'?",
                    transliterationClue = "Hindi: Kitaab / Pustak, Kannada: Pusthaka",
                    emoji = "📖",
                    options = listOf(
                        QuizOption("कलम / ಲೇಖನಿ", "Kalam / Lekhani", "Pen"),
                        QuizOption("किताब / ಪುಸ್ತಕ", "Kitaab / Pusthaka", "Book"),
                        QuizOption("विद्यालय / ಶಾಲೆ", "Vidyalay / Shaale", "School"),
                        QuizOption("दोस्त / ಗೆಳೆಯ", "Dost / Geleya", "Friend")
                    ),
                    correctIndex = 1,
                    explanation = "Kitaab / Pustak in Hindi and Pusthaka in Kannada mean Book!"
                ),
                QuizQuestion(
                    id = "q3_2",
                    prompt = "What is 'School' called in CBSE Hindi and Kannada?",
                    transliterationClue = "Hindi: Vidyalay, Kannada: Shaale",
                    emoji = "🏫",
                    options = listOf(
                        QuizOption("घर / ಮನೆ", "Ghar / Mane", "Home"),
                        QuizOption("दुकान / ಅಂಗಡಿ", "Dukaan / Angadi", "Shop"),
                        QuizOption("विद्यालय / ಶಾಲೆ", "Vidyalay / Shaale", "School"),
                        QuizOption("मैदान / ಮೈದಾನ", "Maidaan / Maidaana", "Playground")
                    ),
                    correctIndex = 2,
                    explanation = "Vidyalay (विद्यालय) and Shaale (ಶಾಲೆ) mean School!"
                ),
                QuizQuestion(
                    id = "q3_3",
                    prompt = "Who is a 'Friend'?",
                    transliterationClue = "Hindi: Dost / Mitra, Kannada: Snehita / Geleya",
                    emoji = "🤝",
                    options = listOf(
                        QuizOption("दोस्त / ಸ್ನೇಹಿತ", "Dost / Snehita", "Friend"),
                        QuizOption("शिक्षक / ಶಿಕ್ಷಕ", "Shikshak / Shikshaka", "Teacher"),
                        QuizOption("भाई / ಅಣ್ಣ", "Bhai / Anna", "Brother"),
                        QuizOption("माता / ಅಮ್ಮ", "Maata / Amma", "Mother")
                    ),
                    correctIndex = 0,
                    explanation = "Dost / Mitra (दोस्त) and Snehita / Geleya (ಸ್ನೇಹಿತ) mean Friend!"
                )
            )
        ),

        Worksheet(
            id = "ws_c3_actions",
            title = "Class 3: Action Words & Sentences",
            cbseClass = 3,
            topic = "Action Verbs",
            icon = "⚡",
            description = "Identify everyday actions: reading, writing, playing, and eating.",
            xpReward = 80,
            questions = listOf(
                QuizQuestion(
                    id = "q4_1",
                    prompt = "Which word means 'To Read'?",
                    transliterationClue = "Hindi: Padhna, Kannada: Ooduvudu",
                    emoji = "📚",
                    options = listOf(
                        QuizOption("लिखना / ಬರೆಯುವುದು", "Likhna / Bareyuvudu", "To Write"),
                        QuizOption("पढ़ना / ಓದುವುದು", "Padhna / Ooduvudu", "To Read"),
                        QuizOption("खेलना / ಆಡುವುದು", "Khelna / Aaduvudu", "To Play"),
                        QuizOption("सोना / ಮಲಗುವುದು", "Sona / Malaguvudu", "To Sleep")
                    ),
                    correctIndex = 1,
                    explanation = "Padhna (पढ़ना) and Ooduvudu (ಓದುವುದು) mean To Read!"
                ),
                QuizQuestion(
                    id = "q4_2",
                    prompt = "Which verb means 'To Play'?",
                    transliterationClue = "Hindi: Khelna, Kannada: Aaduvudu",
                    emoji = "⚽",
                    options = listOf(
                        QuizOption("खाना / ತಿನ್ನುವುದು", "Khaana / Tinnuvudu", "To Eat"),
                        QuizOption("खेलना / ಆಡುವುದು", "Khelna / Aaduvudu", "To Play"),
                        QuizOption("दौड़ना / ಓಡುವುದು", "Daudna / Oduvudu", "To Run"),
                        QuizOption("पीना / ಕುಡಿಯುವುದು", "Peena / Kudiyuvudu", "To Drink")
                    ),
                    correctIndex = 1,
                    explanation = "Khelna (खेलना) and Aaduvudu (ಆಡುವುದು) mean To Play games/sports!"
                ),
                QuizQuestion(
                    id = "q4_3",
                    prompt = "Complete: 'Mera naam ... hai' / 'Nanna hesaru ...'",
                    transliterationClue = "This phrase is used to introduce your...",
                    emoji = "💬",
                    options = listOf(
                        QuizOption("नाम / ಹೆಸರು", "Naam / Hesaru", "Name"),
                        QuizOption("घर / ಮನೆ", "Ghar / Mane", "House"),
                        QuizOption("उम्र / ವಯಸ್ಸು", "Umra / Vayassu", "Age"),
                        QuizOption("स्कूल / ಶಾಲೆ", "School / Shaale", "School")
                    ),
                    correctIndex = 0,
                    explanation = "Naam (नाम) and Hesaru (ಹೆಸರು) mean Name! E.g. 'Mera naam Rahul hai' (My name is Rahul)."
                )
            )
        ),

        Worksheet(
            id = "ws_c4_proverbs",
            title = "Class 4: Moral Values & Proverbs",
            cbseClass = 4,
            topic = "Grammar & Proverbs",
            icon = "👑",
            description = "CBSE proverbs, moral sayings, and advanced conversational understanding.",
            xpReward = 100,
            questions = listOf(
                QuizQuestion(
                    id = "q5_1",
                    prompt = "What does 'Ekta me bal hai' / 'Oggattinalli balavide' mean?",
                    transliterationClue = "A famous Panchatantra moral about staying united!",
                    emoji = "💪",
                    options = listOf(
                        QuizOption("Truth always triumphs", "Satyameva Jayate", "Motto"),
                        QuizOption("Unity is Strength", "Ekta me bal hai", "Moral"),
                        QuizOption("Time is precious", "Samay amulya hai", "Saying"),
                        QuizOption("Hard work pays off", "Mehnat ka phal", "Proverb")
                    ),
                    correctIndex = 1,
                    explanation = "'Ekta me bal hai' (Hindi) and 'Oggattinalli balavide' (Kannada) mean 'Unity is Strength'!"
                ),
                QuizQuestion(
                    id = "q5_2",
                    prompt = "What is the English meaning of 'Satyameva Jayate'?",
                    transliterationClue = "Found on the national emblem of India!",
                    emoji = "⚖️",
                    options = listOf(
                        QuizOption("Truth alone triumphs", "Satya ki jeet hoti hai", "Motto"),
                        QuizOption("Knowledge is light", "Gyaan hi prakash hai", "Saying"),
                        QuizOption("Love all beings", "Sabse prem karo", "Virtue"),
                        QuizOption("Peace for all", "Shanti sabhi ke liye", "Prayer")
                    ),
                    correctIndex = 0,
                    explanation = "Satyameva Jayate means 'Truth Alone Triumphs' (सत्य की हमेशा जीत होती है)."
                ),
                QuizQuestion(
                    id = "q5_3",
                    prompt = "How do you ask 'Where do you live?' politely?",
                    transliterationClue = "Hindi: Aap kahaan rehte hain? / Kannada: Neevu elli vaasisutteeri?",
                    emoji = "🏡",
                    options = listOf(
                        QuizOption("आप कहाँ रहते हैं? / ನೀವು ಎಲ್ಲಿ ವಾಸಿಸುತ್ತೀರಿ?", "Aap kahaan rehte hain? / Neevu elli vaasisutteeri?", "Where do you live?"),
                        QuizOption("आप क्या खाते हैं? / ನೀವು ಏನು ತಿನ್ನುತ್ತೀರಿ?", "Aap kya khaate hain? / Neevu enu tinnutteeri?", "What do you eat?"),
                        QuizOption("आप कब आएंगे? / ನೀವು ಯಾವಾಗ ಬರುತ್ತೀರಿ?", "Aap kab aayenge? / Neevu yaavaaga barutteeri?", "When will you come?"),
                        QuizOption("आप कौन हैं? / ನೀವು ಯಾರು?", "Aap kaun hain? / Neevu yaaru?", "Who are you?")
                    ),
                    correctIndex = 0,
                    explanation = "Aap kahaan rehte hain? and Neevu elli vaasisutteeri? mean 'Where do you live?'"
                )
            )
        )
    )
}
