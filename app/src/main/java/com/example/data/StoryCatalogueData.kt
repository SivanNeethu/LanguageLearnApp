package com.example.data

data class StoryTitleItem(
    val english: String,
    val hindi: String,
    val hindiTranslit: String,
    val kannada: String,
    val kannadaTranslit: String,
    val malayalam: String,
    val malayalamTranslit: String,
    val category: String,
    val emoji: String,
    val themeSummary: String
)

object StoryCatalogueData {

    val allCategories = listOf(
        "All",
        "Motivational & Keep Going",
        "Gratitude & Thankfulness",
        "Respect & Elders",
        "Grounded & Humility",
        "Confidence & Self-Belief",
        "Regular Practice & Discipline",
        "Panchatantra",
        "Akbar & Birbal",
        "Tenali Rama",
        "Jataka Tales",
        "Hitopadesha & Folk"
    )

    // Returns the full list of 300 titles
    fun getTitleItem(index: Int): StoryTitleItem {
        val i = index.coerceIn(1, 300)
        return when {
            i <= 30 -> getPanchatantraTitle(i)
            i <= 55 -> getAkbarBirbalTitle(i)
            i <= 80 -> getTenaliRamaTitle(i)
            i <= 105 -> getJatakaTitle(i)
            i <= 140 -> getMotivationalTitle(i)
            i <= 175 -> getGratitudeTitle(i)
            i <= 210 -> getRespectTitle(i)
            i <= 245 -> getGroundedHumilityTitle(i)
            i <= 275 -> getConfidenceTitle(i)
            else -> getPracticeDisciplineTitle(i)
        }
    }

    private fun getPanchatantraTitle(i: Int): StoryTitleItem {
        val list = listOf(
            StoryTitleItem("The Thirsty Crow", "प्यासा कौआ", "Pyaasa Kauwa", "ಬಾಯಾರಿದ ಕಾಗೆ", "Baayarida Kaage", "ദാഹിച്ച കാക്ക", "Daahicha Kaakka", "Panchatantra", "🦅", "Resourcefulness and persistence bring water within reach."),
            StoryTitleItem("The Lion and the Clever Mouse", "शेर और छोटा चूहा", "Sher aur Chhota Chooha", "ಸಿಂಹ ಮತ್ತು ಚುರುಕು ಇಲಿ", "Simha mattu Churuku Ili", "സിംഹവും കൊച്ചു എലിയും", "Simhavum Kochu Eliyum", "Panchatantra", "🦁", "No act of kindness, however small, is ever wasted."),
            StoryTitleItem("The Hare and the Tortoise", "खरगोश और कछुआ", "Khargosh aur Kachhua", "ಮೊಲ ಮತ್ತು ಆಮೆ", "Mola mattu Aame", "മുയലും ആമയും", "Muyalum Aamayum", "Panchatantra", "🐢", "Slow and steady wins the race with quiet determination."),
            StoryTitleItem("The Monkey and the Crocodile", "बंदर और मगरमच्छ", "Bandar aur Magarmachh", "ಮಂಗ ಮತ್ತು ಮೊಸಳೆ", "Manga mattu Mosale", "കുരങ്ങനും മുതലയും", "Kuranganum Muthalayum", "Panchatantra", "🐒", "Quick presence of mind can save you from grave danger."),
            StoryTitleItem("The Blue Jackal", "नीला सियार", "Neela Siyaar", "ನೀಲಿ ನರಿ", "Neeli Nari", "നീലക്കുറുക്കൻ", "Neelakkurukkan", "Panchatantra", "🦊", "Pretending to be what you are not brings sorrow."),
            StoryTitleItem("The Fox and the Sour Grapes", "लोमड़ी और खट्टे अंगूर", "Lomdi aur Khatte Angoor", "ನರಿ ಮತ್ತು ಹುಳಿ ದ್ರಾಕ್ಷಿ", "Nari mattu Huli Draakshi", "കുറുക്കനും പുളിക്കുന്ന മുന്തിരിയും", "Kurukkanum Pulikkunna Munthiriyum", "Panchatantra", "🍇", "Do not despise what you cannot attain through effort."),
            StoryTitleItem("The Four Faithful Friends", "चार पक्के दोस्त", "Chaar Pakke Dost", "ನಾಲ್ಕು ಆಪ್ತ ಸ್ನೇಹಿತರು", "Naalku Aapta Snehitaru", "നാല് ഉത്തമ സുഹൃത്തുക്കൾ", "Naalu Uthama Suhruthukkal", "Panchatantra", "🦌", "True friendship overcomes all adversity when united."),
            StoryTitleItem("The Ant and the Dove", "चींटी और कबूतर", "Cheenti aur Kabootar", "ಇರುವೆ ಮತ್ತು ಪಾರಿವಾಳ", "Iruve mattu Paarivaala", "ഉറുമ്പും പ്രാവും", "Urumbum Praavum", "Panchatantra", "🕊️", "A good deed returns when you least expect it."),
            StoryTitleItem("The Golden Egg Goose", "सोने का अंडा", "Sone ka Anda", "ಚಿನ್ನದ ಮೊಟ್ಟೆ", "Chinnada Motte", "പൊൻമുട്ടയിടുന്ന താറാവ്", "Ponmutta Idunna Thaaraavu", "Panchatantra", "🪿", "Greed destroys the source of prosperity."),
            StoryTitleItem("The Two Silly Goats", "दो नादान बकरियां", "Do Naadan Bakriyaan", "ಎರಡು ಮೊಂಡು ಆಡುಗಳು", "Eradu Mondu Aadugalu", "രണ്ട് വിഡ്ഢി ആടുകൾ", "Randu Viddhi Aadukal", "Panchatantra", "🐐", "Stubborn pride leads only to mutual downfall.")
        )
        val item = list[(i - 1) % list.size]
        return item.copy(english = "${item.english} #$i")
    }

    private fun getAkbarBirbalTitle(i: Int): StoryTitleItem {
        val list = listOf(
            StoryTitleItem("Birbal's Khichdi", "बीरबल की खिचड़ी", "Birbal ki Khichdi", "ಬೀರಬಲ್ಲನ ಖಿಚಡಿ", "Beeraballana Khichadi", "ബീർബലിന്റെ കിച്ചടി", "Birbalinte Kichadi", "Akbar & Birbal", "🍲", "Patience and clever demonstration awaken justice."),
            StoryTitleItem("Counting the Crows", "कौवे गिनना", "Kauwe Ginna", "ಕಾಗೆಗಳ ಲೆಕ್ಕ", "Kaagegala Lekka", "കാക്കകളെ എണ്ണൽ", "Kaakkakale Ennal", "Akbar & Birbal", "👑", "Witty logic easily solves seemingly impossible questions."),
            StoryTitleItem("The Straw in the Beard", "दाढ़ी में तिनका", "Daadhi me Tinka", "ಗಡ್ಡದಲ್ಲಿ ಕಡ್ಡಿ", "Gaddadalli Kaddi", "താടിയിലെ പുൽക്കൊടി", "Thaadiyile Pulkkodi", "Akbar & Birbal", "⚖️", "A guilty conscience betrays itself without an accuser."),
            StoryTitleItem("The Pot of Wisdom", "अकल का घड़ा", "Akal ka Ghada", "ಬುದ್ಧಿಯ ಮಡಕೆ", "Buddhiya Madake", "ബുദ്ധിയുടെ കലം", "Buddhiyude Kalam", "Akbar & Birbal", "🏺", "Wisdom is measured by actions, not empty words."),
            StoryTitleItem("The Well Water Dispute", "कुएं का पानी", "Kuen ka Paani", "ಬಾವಿಯ ನೀರಿನ ತೀರ್ಪು", "Baaviya Neerina Teerpu", "കിണറ്റുവെള്ള തർക്കം", "Kinattuvella Tharkkam", "Akbar & Birbal", "💧", "Deception falls into the pit it digs for others.")
        )
        val item = list[(i - 31) % list.size]
        return item.copy(english = "${item.english} (Part ${i - 30})")
    }

    private fun getTenaliRamaTitle(i: Int): StoryTitleItem {
        val list = listOf(
            StoryTitleItem("Tenali Rama and the Well Thieves", "तेनाली राम और कुएं के चोर", "Tenali Ram aur Kuen ke Chor", "ತೆನಾಲಿ ಮತ್ತು ಬಾವಿಯ ಕಳ್ಳರು", "Tenali mattu Baaviya Kallaru", "തെനാലി രാമനും കള്ളന്മാരും", "Tenali Raamanum Kallanmaarum", "Tenali Rama", "🧠", "Turn difficult circumstances into productive blessings."),
            StoryTitleItem("The Cat that Feared Warm Milk", "दूध से डरने वाली बिल्ली", "Doodh se Darne Waali Billi", "ಹಾಲಿಗೆ ಹೆದರುವ ಬೆಕ್ಕು", "Haalige Hedaruvad Bekku", "ചൂടുപാലിനെ ഭയന്ന പൂച്ച", "Choodupaaline Bhayanna Poocha", "Tenali Rama", "🐈", "Sensible animals learn from harsh experiences."),
            StoryTitleItem("Tenali's Blank Canvas", "खाली कैनवास की तस्वीर", "Khaali Canvas ki Tasveer", "ಖಾಲಿ ಚಿತ್ರಪಟ", "Khaali Chitrapatha", "ശൂന്യമായ ക്യാൻവാസ്", "Shoonyamaaya Canvas", "Tenali Rama", "🎨", "Art requires imagination and seeing beyond the obvious."),
            StoryTitleItem("The Brinjal from the Royal Garden", "शाही बैंगन की सीख", "Shaahi Baingan ki Seekh", "ರಾಜ ಬದನೆಕಾಯಿಯ ರಹಸ್ಯ", "Raaja Badanekayiya Rahasya", "രാജകീയ വഴുതനങ്ങ", "Raajakeeya Vazhuthinanga", "Tenali Rama", "🍆", "Quick wit protects innocence in delicate dilemmas."),
            StoryTitleItem("The Proud Scholar's Defeat", "घमंडी विद्वान की पराजय", "Ghamandi Vidwaan ki Paraajay", "ಅಹಂಕಾರಿ ಪಂಡಿತನ ಸೋಲು", "Ahamkaari Panditana Solu", "അഹങ്കാരിയായ പണ്ഡിതൻ", "Ahankaariyaaya Pandithan", "Tenali Rama", "📜", "Humility triumphs over loud pedantic arrogance.")
        )
        val item = list[(i - 56) % list.size]
        return item.copy(english = "${item.english} #${i - 55}")
    }

    private fun getJatakaTitle(i: Int): StoryTitleItem {
        val list = listOf(
            StoryTitleItem("The Golden Deer of Compassion", "दयालु सुनहरा हिरन", "Dayaalu Sunahra Hiran", "ಕರುಣಾಮಯಿ ಚಿನ್ನದ ಜಿಂಕೆ", "Karunaamayi Chinnada Jinke", "ദയയുള്ള സുവർണ്ണ മാൻ", "Dayayulla Suvarna Maan", "Jataka Tales", "🦌", "Compassion and willingness to sacrifice melt hard hearts."),
            StoryTitleItem("The Honest Woodcutter's Reward", "ईमानदार लकड़हारा", "Imaandaar Lakadhara", "ಪ್ರಾಮಾಣಿಕ ಕಟ್ಟಿಗೆ ಕಡಿಯುವವನು", "Praamaanika Kattige Kadiyuvavanu", "സത്യസന്ധനായ വിറകുവെട്ടുകാരൻ", "Sathyasandhanaaya Viraku Vettukaaran", "Jataka Tales", "🪓", "Uncompromising honesty receives nature's greatest gifts."),
            StoryTitleItem("The Brave Little Quail", "साहसी नन्ही बटेर", "Saahasi Nanhi Bater", "ಧೀರ ಪುಟ್ಟ ಲಾವಕ್ಕಿ", "Dheera Putta Laavakki", "ധീരയായ കൊച്ചു കാടപക്ഷി", "Dheerayaaya Kochu Kaadapakshi", "Jataka Tales", "🕊️", "Even the tiniest creature can protect its home with bravery."),
            StoryTitleItem("The Monkey King's Bridge", "वानर राज का त्याग", "Vaanar Raaj ka Tyaag", "ವಾನರ ರಾಜನ ತ್ಯಾಗ", "Vaanara Raajana Tyaaga", "കുരങ്ങുരാജാവിന്റെ സേതു", "Kuranguraajaavinte Sethu", "Jataka Tales", "🌉", "True leaders sacrifice their own comfort to save followers."),
            StoryTitleItem("The Grateful Elephant's Friendship", "कृतज्ञ हाथी और पिल्ला", "Kritagya Haathi aur Pilla", "ಕೃತಜ್ಞ ಆನೆ ಮತ್ತು ನಾಯಿಮರಿ", "Kritajna Aane mattu Naayimari", "നന്ദിയുള്ള ആനയും നായക്കുട്ടിയും", "Nandiyulla Aanayum Naayakuttiyum", "Jataka Tales", "🐘", "Affection knows no boundaries of size or species.")
        )
        val item = list[(i - 81) % list.size]
        return item.copy(english = "${item.english} #${i - 80}")
    }

    // 106 - 140: Motivational & Keep Going
    private fun getMotivationalTitle(i: Int): StoryTitleItem {
        val titles = listOf(
            "The Little Ant's Steep Climb" to Triple("नन्ही चींटी की ऊँची चढ़ाई (Nanhi Cheenti ki Oonchi Chadhaai)", "ಪುಟ್ಟ ಇರುವೆ ಎತ್ತರದ ಹತ್ತುವಿಕೆ (Putta Iruve Ettarada Hattuvike)", "ചെറിയ ഉറുമ്പിന്റെ മലകയറ്റം (Cheriya Urumbinte Malakayattam)"),
            "Never Give Up, Keep Going" to Triple("कभी मत रुको, आगे बढ़ो (Kabhi Mat Ruko, Aage Badho)", "ಎಂದೂ ನಿಲ್ಲಬೇಡ, ಮುನ್ನಡೆ (Endoo Nillabeda, Munnade)", "ഒരിക്കലും തളരരുത്, മുന്നേറുക (Orikkalum Thalararuthu, Munneruka)"),
            "The Sprout that Broke the Stone" to Triple("पत्थर चीरकर निकला अंकुर (Patthar Cheer-kar Nikla Ankur)", "ಬಂಡೆ ಒಡೆದ ಪುಟ್ಟ ಮೊಳಕೆ (Bande Odeda Putta Molake)", "പാറ പിളർന്നു മുളച്ച വിത്ത് (Paara Pilarnnu Mulacha Vithu)"),
            "The Runner with Bruised Knees" to Triple("घुटने छिलने पर भी दौड़ (Ghutne Chhilne par bhi Daud)", "ಬಿದ್ದರೂ ಎದ್ದು ಓಡಿದ ಬಾಲಕ (Biddaroo Eddu Odida Baalaka)", "വീണിട്ടും എഴുന്നേറ്റ ഓട്ടക്കാരൻ (Veenittum Ezhunnetta Oattakkaaran)"),
            "The Lamp that Fought the Storm" to Triple("तूफान से लड़ा नन्हा दीपक (Toofaan se Lada Nanha Deepak)", "ಬಿರುಗಾಳಿಗೆ ಎದೆಯೊಡ್ಡಿದ ದೀಪ (Birugaalige Edeyoddida Deepa)", "കൊടുങ്കാറ്റിനെ നേരിട്ട ദീപം (Kodunkaattine Neritta Deepam)"),
            "The Eagle's Second Flight" to Triple("बाज़ की दूसरी उड़ान (Baaz ki Doosri Udaan)", "ಹದ್ದು ಮತ್ತೊಮ್ಮೆ ಹಾರಿತು (Haddu Mattomme Haaritu)", "കഴുകന്റെ രണ്ടാം പറക്കൽ (Kazhukante Randaam Parakkal)"),
            "Step by Step to the Mountaintop" to Triple("कदम दर कदम शिखर तक (Kadam dar Kadam Shikhar tak)", "ಹೆಜ್ಜೆ ಹೆಜ್ಜೆಯಿಟ್ಟು ಶಿಖರ ತಲುಪಿದ (Hejje Hejjeyittu Shikhara Talupida)", "പടവുകൾ കയറി കൊടുമുടിയിലേക്ക് (Padavukal Kayari Kodumudiyilekku)"),
            "The River that Pierced the Mountain" to Triple("पहाड़ चीरने वाली सरिता (Pahaad Cheerne Waali Sarita)", "ಬೆಟ್ಟವನ್ನು ಸೀಳಿದ ನದಿ (Bettavannu Seelida Nadi)", "മലതുരന്നൊഴുകിയ നദി (Malathurannozhukiya Nadi)"),
            "The Clock that Never Stopped" to Triple("कभी न रुकने वाली घड़ी (Kabhi na Rukne Waali Ghadi)", "ನಿಲ್ಲದೆ ಓಡುವ ಗಡಿಯಾರ (Nillade Oduva Gadiyaara)", "നിലയ്ക്കാത്ത നാഴികമണി (Nilaykkaatha Naazhikamani)"),
            "The Brave Firefly in the Rain" to Triple("बारिश में चमकता जुगनू (Baarish me Chamakta Jugnu)", "ಮಳೆಯಲ್ಲಿ ಹೊಳೆದ ಮಿಂಚುಹುಳು (Maleyalli Holeda Minchuhulu)", "മഴയത്തും മിന്നിയ മിന്നാമിനുങ്ങ് (Mazhayathum Minniya Minnaaminungu)")
        )
        val (eng, triple) = titles[(i - 106) % titles.size]
        val (hiScript, hiTrans) = parseScriptAndTranslit(triple.first)
        val (knScript, knTrans) = parseScriptAndTranslit(triple.second)
        val (mlScript, mlTrans) = parseScriptAndTranslit(triple.third)
        return StoryTitleItem(
            english = "$eng #${i - 105}",
            hindi = hiScript,
            hindiTranslit = hiTrans,
            kannada = knScript,
            kannadaTranslit = knTrans,
            malayalam = mlScript,
            malayalamTranslit = mlTrans,
            category = "Motivational & Keep Going",
            emoji = listOf("🧗", "🚀", "🌟", "⚡", "🦅", "🔥", "🌈")[(i - 106) % 7],
            themeSummary = "Fall seven times, rise eight. Never let setbacks halt your continuous forward stride."
        )
    }

    // 141 - 175: Gratitude & Thankfulness
    private fun getGratitudeTitle(i: Int): StoryTitleItem {
        val titles = listOf(
            "The Farmer's Thankful Heart" to Triple("किसान का कृतज्ञ मन (Kisaan ka Kritagya Man)", "ರೈತನ ಕೃತಜ್ಞತೆಯ ಹೃದಯ (Raitana Kritajnateya Hrudaya)", "കർഷകന്റെ നന്ദിയുള്ള ഹൃദയം (Karshakante Nandiyulla Hrudayam)"),
            "The Tree of Generous Blessings" to Triple("वरदान देने वाला वृक्ष (Vardaan Dene Waala Vriksh)", "ವರ ನೀಡಿದ ಪುಣ್ಯ ವೃಕ್ಷ (Vara Needida Punya Vriksha)", "അനുഗ്രഹങ്ങൾ ചൊരിഞ്ഞ മരം (Anugrahangal Chorinja Maram)"),
            "Meera's Gratitude Notebook" to Triple("मीरा की धन्यवाद डायरी (Meera ki Dhanyavaad Diary)", "ಮೀರಾಗೆ ಧನ್ಯವಾದ ತಿಳಿಸಿದ ದಿನ (Meeraage Dhanyavaada Tilisida Dina)", "മീരയുടെ നന്ദി ഡയറി (Meerayude Nandi Diary)"),
            "The Cool Spring of Pure Water" to Triple("शीतल जल का उपहार (Sheetal Jal ka Upahaar)", "ತಣ್ಣನೆಯ ಬುಗ್ಗೆಯ ಉಡುಗೊರೆ (Tannaneya Buggeya Udugore)", "കുളിർനീരുറവയുടെ ദാനം (Kulirneeruravayude Daanam)"),
            "Counting Morning Blessings" to Triple("सुबह की खुशियों की गिनती (Subah ki Khushiyon ki Ginti)", "ಬೆಳಗಿನ ಶುಭ ಆಶೀರ್ವಾದಗಳು (Belagina Shubha Aasheervaadagalu)", "പ്രഭാതാനുഗ്രഹങ്ങൾ എണ്ണുമ്പോൾ (Prabhaathaanugrahangal Ennumbol)"),
            "The Old Grandmother's Warm Shawl" to Triple("दादी माँ का स्नेह भरा शॉल (Daadi Maa ka Sneh Bhara Shawl)", "ಅಜ್ಜಿಯ ಪ್ರೀತಿಯ ಬೆಚ್ಚನೆಯ ಶಾಲು (Ajjiya Preetiya Bechchaneya Shaalu)", "മുത്തശ്ശിയുടെ സ്നേഹപ്പുതപ്പ് (Muthasshiyude Snehapputhappu)"),
            "The River that Asked for Nothing" to Triple("निःस्वार्थ बहती पावन नदी (Nihswaarth Behti Paavan Nadi)", "ಏನನ್ನೂ ಬೇಡದ ಪಾವನ ನದಿ (Enannoo Bedada Paavana Nadi)", "പ്രതിഫലം കാംക്ഷിക്കാത്ത പുഴ (Prathiphalam Kaamkshikkaatha Puzha)"),
            "The Little Girl and the Starry Sky" to Triple("तारों भरे आसमान का धन्यवाद (Taaron Bhare Aasmaan ka Dhanyavaad)", "ನಕ್ಷತ್ರಲೋಕಕ್ಕೆ ಕೃತಜ್ಞತೆ (Nakshatralokakke Kritajnate)", "നക്ഷത്രങ്ങൾക്ക് നന്ദി പറഞ്ഞ കുട്ടി (Nakshathrangalkku Nandi Paranja Kutti)")
        )
        val (eng, triple) = titles[(i - 141) % titles.size]
        val (hiScript, hiTrans) = parseScriptAndTranslit(triple.first)
        val (knScript, knTrans) = parseScriptAndTranslit(triple.second)
        val (mlScript, mlTrans) = parseScriptAndTranslit(triple.third)
        return StoryTitleItem(
            english = "$eng #${i - 140}",
            hindi = hiScript,
            hindiTranslit = hiTrans,
            kannada = knScript,
            kannadaTranslit = knTrans,
            malayalam = mlScript,
            malayalamTranslit = mlTrans,
            category = "Gratitude & Thankfulness",
            emoji = listOf("🙏", "🌸", "💖", "🌾", "🍯", "🌻", "🪴")[(i - 141) % 7],
            themeSummary = "A thankful heart turns what little we have into abundance and daily joy."
        )
    }

    // 176 - 210: Respect & Elders
    private fun getRespectTitle(i: Int): StoryTitleItem {
        val titles = listOf(
            "The Sage and the Polite Disciple" to Triple("विनम्र शिष्य और गुरुजी (Vinamra Shishya aur Guruji)", "ವಿನಮ್ರ ಶಿಷ್ಯ ಮತ್ತು ಗುರು (Vinamra Shishya mattu Guru)", "ഗുരുവും വിനീതനായ ശിഷ്യനും (Guruvum Vineethanaaya Shishyanum)"),
            "Bowing to the Ancient Banyan" to Triple("बरगद के आगे सिर झुकाना (Bargad ke Aage Sir Jhukaana)", "ಹಿರಿಯ ಆಲದ ಮರಕ್ಕೆ ನಮನ (Hiriya Aalada Marakke Namana)", "വന്മരത്തെ ആദരിച്ചവൻ (Vanmaraththe Aadarichavan)"),
            "Grandmother's Walking Cane" to Triple("दादी जी की लाठी का सहारा (Daadi ji ki Laathi ka Sahaara)", "ಅಜ್ಜಿಯ ಊರುಗೋಲಿನ ಗೌರವ (Ajjiya Oorugolina Gaurava)", "മുത്തശ്ശിയുടെ വടിയും സ്നേഹവും (Muthasshiyude Vadiyum Snehavum)"),
            "The Gentle Voice of the Teacher" to Triple("शिक्षक की मधुर सीख (Shikshak ki Madhur Seekh)", "ಗುರುವಿನ ಮಧುರ ಮಾರ್ಗದರ್ಶನ (Guruvina Madhura Maargadarshana)", "ഗുരുവിന്റെ വാത്സല്യ വചനങ്ങൾ (Guruvinte Vaathsalyavachanangal)"),
            "Touching Mother's Feet with Love" to Triple("माँ के चरणों में नमन (Maa ke Charnon me Naman)", "ತಾಯಿಯ ಪಾದಸ್ಪರ್ಶದ ಪುಣ್ಯ (Taayiya Paadasparshada Punya)", "അമ്മയുടെ കാൽതൊട്ടു വണങ്ങുമ്പോൾ (Ammayude Kaalthottu Vanangumpol)"),
            "The Boy Who Offered His Seat" to Triple("बुजुर्ग को जगह देने वाला बालक (Bujurg ko Jagah Dene Waala Baalak)", "ಹಿರಿಯರಿಗೆ ಆಸನ ಬಿಟ್ಟ ಬಾಲಕ (Hiriyarige Aasana Bitta Baalaka)", "മുതിർന്നവർക്ക് വഴിമാറിയ ബാലൻ (Muthirnavarkku Vazhimaariya Baalan)"),
            "Honoring the Village Elder's Word" to Triple("गाँव के मुखिया का आदर (Gaanw ke Mukhiya ka Aadar)", "ಹಿರಿಯರ ಮಾತಿಗೆ ಗೌರವ (Hiriyara Maatige Gaurava)", "നാട്ടുമുപ്പന്റെ വാക്കുകൾ കേൾക്കുമ്പോൾ (Naattumooppante Vaakkukal Kelkkumpol)"),
            "Listening Without Interrupting" to Triple("ध्यान से सुनने का संस्कार (Dhyaan se Sunne ka Sanskaar)", "ಶಾಂತವಾಗಿ ಕೇಳುವ ಸಂಸ್ಕಾರ (Shaantavaagi Keluva Samskaara)", "ശ്രദ്ധയോടെ കേട്ടിരുന്നവൻ (Shraddhayode Kettirunnavan)")
        )
        val (eng, triple) = titles[(i - 176) % titles.size]
        val (hiScript, hiTrans) = parseScriptAndTranslit(triple.first)
        val (knScript, knTrans) = parseScriptAndTranslit(triple.second)
        val (mlScript, mlTrans) = parseScriptAndTranslit(triple.third)
        return StoryTitleItem(
            english = "$eng #${i - 175}",
            hindi = hiScript,
            hindiTranslit = hiTrans,
            kannada = knScript,
            kannadaTranslit = knTrans,
            malayalam = mlScript,
            malayalamTranslit = mlTrans,
            category = "Respect & Elders",
            emoji = listOf("👴", "👵", "🙇", "🪷", "📜", "🕊️", "🏡")[(i - 176) % 7],
            themeSummary = "True culture shines when we honor our parents, teachers, and elders with loving courtesy."
        )
    }

    // 211 - 245: Grounded & Humility (not to show off)
    private fun getGroundedHumilityTitle(i: Int): StoryTitleItem {
        val titles = listOf(
            "The Full Vessel Makes No Sound" to Triple("गंभीर सागर और उथला पानी (Gambheer Saagar aur Uthla Paani)", "ತುಂಬಿದ ಕೊಡ ತುಳುಕುವುದಿಲ್ಲ (Tumbida Koda Tulukuvudilla)", "നിറഞ്ഞ കുടം തുളുമ്പില്ല (Niranja Kudam Thulumpilla)"),
            "The Fruit-Laden Tree Bends Low" to Triple("फलों से लदा विनम्र पेड़ (Phalon se Lada Vinamra Ped)", "ಹಣ್ಣುಗಳಿಂದ ಬಾಗಿದ ವೃಕ್ಷ (Hannugalinda Baagida Vriksha)", "ഫലഭാരത്താൽ കുനിഞ്ഞ മരം (Phalabhaaraththaal Kuninja Maram)"),
            "The Peacock Who Stopped Showing Off" to Triple("घमंड छोड़ने वाला मोर (Ghamand Chhodne Waala Mor)", "ಆಡಂಬರ ಬಿಟ್ಟ ನವಿಲು (Aadambara Bitta Navilu)", "പൊങ്ങച്ചം വെടിഞ്ഞ മയിൽ (Pongacham Vedinja Mayil)"),
            "The Diamond in Plain Soil" to Triple("साधारण मिट्टी में छिपा हीरा (Saadhaaran Mitti me Chhipa Heera)", "ಮಣ್ಣಿನಲ್ಲಿ ಹೊಳೆದ ವಜ್ರ (Manninalli Holeda Vajra)", "മൺതരിയിലെ തിളങ്ങുന്ന രത്നം (Manthariyile Thilangunna Rathnam)"),
            "The King in Simple Cotton Clothes" to Triple("सादे वस्त्रों में दयालु राजा (Saade Vasktron me Dayaalu Raja)", "ಸರಳ ವಸ್ತ್ರದ ಮಹಾರಾಜ (Sarala Vastrada Mahaaraaja)", "ലളിതവസ്ത്രം ധരിച്ച രാജാവ് (Lalithavasthram Dharicha Raajaavu)"),
            "The Quiet Cloud that Rained Peace" to Triple("बिना गरजे बरसने वाला बादल (Bina Garje Barasne Waala Baadal)", "ಗರ್ಜಿಸದೆ ತಂಪೆರೆದ ಮೋಡ (Garjisade Tampereda Moda)", "മുഴങ്ങാതെ പെയ്ത മഴമേഘം (Muzhangaathe Peytha Mazhamegham)"),
            "The Secret Good Deed" to Triple("गुप्त भलाई की सुगंध (Gupt Bhalaai ki Sugandh)", "ಗುಪ್ತ ದಾನದ ಸಾರ್ಥಕತೆ (Gupta Daanada Saarthakate)", "രഹസ്യമായി ചെയ്ത നന്മ (Rahasyamaayi Cheytha Nanma)"),
            "The Humble Potter's Masterpiece" to Triple("विनम्र कुम्हार की अद्भुत कला (Vinamra Kumhaar ki Adbhut Kala)", "ನಮ್ರ ಕುಂಬಾರನ ಸುಂದರ ಕಲೆ (Namra Kumbaarana Sundara Kale)", "വിനീതനായ കുശവന്റെ സൃഷ്ടി (Vineethanaaya Kushavante Srishti)")
        )
        val (eng, triple) = titles[(i - 211) % titles.size]
        val (hiScript, hiTrans) = parseScriptAndTranslit(triple.first)
        val (knScript, knTrans) = parseScriptAndTranslit(triple.second)
        val (mlScript, mlTrans) = parseScriptAndTranslit(triple.third)
        return StoryTitleItem(
            english = "$eng #${i - 210}",
            hindi = hiScript,
            hindiTranslit = hiTrans,
            kannada = knScript,
            kannadaTranslit = knTrans,
            malayalam = mlScript,
            malayalamTranslit = mlTrans,
            category = "Grounded & Humility",
            emoji = listOf("🌱", "🏺", "🌿", "💎", "🌾", "🕊️", "🍵")[(i - 211) % 7],
            themeSummary = "True greatness stays grounded and avoids empty boastfulness. Humility is the greatest ornament."
        )
    }

    // 246 - 275: Confidence & Self-Belief
    private fun getConfidenceTitle(i: Int): StoryTitleItem {
        val titles = listOf(
            "The Little Rabbit Who Found His Courage" to Triple("नन्हे खरगोश का आत्मविश्वास (Nanhe Khargosh ka Aatmavishvaas)", "ಧೈರ್ಯ ತಾಳಿದ ಪುಟ್ಟ ಮೊಲ (Dhairya Taalida Putta Mola)", "ധൈര്യം വീണ്ടെടുത്ത മുയൽക്കുഞ്ഞ് (Dhairyam Veendedutha Muyalkkunju)"),
            "Believing in Your Own Wings" to Triple("अपने पंखों पर सच्चा विश्वास (Apne Pankhon par Sachha Vishvaas)", "ಸ್ವಂತ ರೆಕ್ಕೆಯ ಮೇಲೆ ನಂಬಿಕೆ (Svanta Rekkeya Mele Nambike)", "സ്വന്തം ചിറകുകളിൽ വിശ്വസിക്കുക (Swantham Chirakukalil Vishwasikkuka)"),
            "The Child Who Dared to Speak Truth" to Triple("सच बोलने का असीम साहस (Sach Bolne ka Aseem Saahas)", "ಸತ್ಯ ನುಡಿಯುವ ಧೈರ್ಯಶಾಲಿ ಮಗು (Satya Nudiyuva Dhairyashaali Magu)", "സത്യം പറയാൻ തുനിഞ്ഞ കുട്ടി (Sathyam Parayaan Thuninja Kutti)"),
            "The Little Boat that Crossed the Deep Lake" to Triple("गहरी झील पार करने वाली नाव (Gehri Jheel Paar Karne Waali Naav)", "ಸರೋವರ ದಾಟಿದ ಪುಟ್ಟ ದೋಣಿ (Sarovara Daatida Putta Doni)", "കായൽ കടന്ന കൊച്ചുതോണി (Kaayal Kadanna Kochuthoni)"),
            "The Songbird with Her Own Melody" to Triple("अपनी अनूठी तान गाने वाली चिड़िया (Apni Anoothee Taan Gaane Waali Chidiya)", "ಸ್ವಂತ ರಾಗ ಹಾಡಿದ ಹಕ್ಕಿ (Svanta Raaga Haadida Hakki)", "സ്വന്തം ഈണം മൂളിയ കിളി (Swantham Eenam Mooliya Kili)"),
            "The Lion Cub Who Learned His Roar" to Triple("नन्हे शावक की गर्जना (Nanhe Shaawak ki Garjna)", "ಗರ್ಜಿಸಲು ಕಲಿತ ಸಿಂಹದ ಮರಿ (Garjisalu Kalita Simhada Mari)", "ഗർജ്ജിക്കാൻ പഠിച്ച സിംഹക്കുട്ടി (Garjjikkaan Padicha Simhakkutti)"),
            "Overcoming the Shadow of Fear" to Triple("डर के साए को हराना (Dar ke Saaye ko Haraana)", "ಭಯದ ನೆರಳನ್ನು ಮೆಟ್ಟಿನಿಂತ (Bhayada Neralannu Mettininta)", "ഭയത്തിന്റെ നിഴലകറ്റിയ ബാലൻ (Bhayathinte Nizhalakattiya Baalan)")
        )
        val (eng, triple) = titles[(i - 246) % titles.size]
        val (hiScript, hiTrans) = parseScriptAndTranslit(triple.first)
        val (knScript, knTrans) = parseScriptAndTranslit(triple.second)
        val (mlScript, mlTrans) = parseScriptAndTranslit(triple.third)
        return StoryTitleItem(
            english = "$eng #${i - 245}",
            hindi = hiScript,
            hindiTranslit = hiTrans,
            kannada = knScript,
            kannadaTranslit = knTrans,
            malayalam = mlScript,
            malayalamTranslit = mlTrans,
            category = "Confidence & Self-Belief",
            emoji = listOf("🦁", "🛡️", "⛵", "🎯", "🌟", "🪶", "🏹")[(i - 246) % 7],
            themeSummary = "Believe in your inner light and strength. Courage is born when self-doubt is replaced by action."
        )
    }

    // 276 - 300: Regular Practice & Discipline (Abhyasa)
    private fun getPracticeDisciplineTitle(i: Int): StoryTitleItem {
        val titles = listOf(
            "The Water Drop that Carved the Granite" to Triple("पत्थर पर निशान बनाती बूँद (Patthar par Nishaan Banaati Boond)", "ಬಂಡೆಯನ್ನು ಕೊರೆದ ನೀರಿನ ಹನಿ (Bandeyannu Koreda Neerina Hani)", "പാറ തുളച്ച വെള്ളത്തുള്ളി (Paara Thulacha Vellathulli)"),
            "Sage Varadaraja and the Well Rope" to Triple("करत-करत अभ्यास की अमर सीख (Karat-Karat Abhyaas ki Amar Seekh)", "ಹಗ್ಗದ ಗುರುತು ಮತ್ತು ನಿರಂತರ ಅಭ್ಯಾಸ (Haggada Gurutu mattu Nirantara Abhyaasa)", "കിണറ്റുകയറും നിരന്തര പരിശീലനവും (Kinattukayarum Niranthara Parisheelanavum)"),
            "The Archer's Daily Morning Target" to Triple("धनुर्धर का नित्य सवेरे अभ्यास (Dhanurdhar ka Nitya Savere Abhyaas)", "ಬಿಲ್ಲುಗಾರನ ನಿತ್ಯ ಸಾಧನೆ (Billugaarana Nitya Saadhane)", "വില്ലാളിയുടെ ദിനചര്യ (Villaaliyude Dinacharya)"),
            "The Young Musician's Daily Scales" to Triple("वीणा के तारों का रोज़ रियाज़ (Veena ke Taaron ka Roz Riyaaz)", "ವೀಣೆಯ ತಂತಿಗಳ ದಿನನಿತ್ಯದ ಸಾಧನೆ (Veeneya Tantigala Dinanityada Saadhane)", "വീണ മീട്ടിയ കൊച്ചുകൈകൾ (Veena Meettiya Kochukaikal)"),
            "One Page Every Single Day" to Triple("हर दिन एक पन्ना लिखना (Har Din Ek Panna Likhna)", "ಪ್ರತಿದಿನ ಒಂದೊಂದು ಪುಟ ಬರೆದ (Pratidina Ondondu Puta Bareda)", "ദിനവും ഒരു താൾ വായിച്ചപ്പോൾ (Dinavum Oru Thaal Vaayichappol)"),
            "The Potter's Thousand Vessels" to Triple("मिट्टी को गढ़ने का निरंतर श्रम (Mitti ko Gadhne ka Nirantar Shram)", "ಕುಂಬಾರನ ನಿತ್ಯ ಚಕ್ರದ ಪಯಣ (Kumbaarana Nitya Chakrada Payana)", "കുശവന്റെ നിത്യസാധന (Kushavante Nityasaadhana)"),
            "The Runner Who Practiced in Rain and Sun" to Triple("धूप-छाँव में दौड़ने वाला धावक (Dhoop-Chhaanv me Daudne Waala Dhaawak)", "ಮಳೆ-ಬಿಸಿಲಿನಲ್ಲಿ ಓಡಿದ ಓಟಗಾರ (Male-Bisilinalli Odida Ootagaara)", "മഴയിലും വെയിലിലും ഓടിയവൻ (Mazhayilum Veyililum Oadiyavan)")
        )
        val (eng, triple) = titles[(i - 276) % titles.size]
        val (hiScript, hiTrans) = parseScriptAndTranslit(triple.first)
        val (knScript, knTrans) = parseScriptAndTranslit(triple.second)
        val (mlScript, mlTrans) = parseScriptAndTranslit(triple.third)
        return StoryTitleItem(
            english = "$eng #${i - 275}",
            hindi = hiScript,
            hindiTranslit = hiTrans,
            kannada = knScript,
            kannadaTranslit = knTrans,
            malayalam = mlScript,
            malayalamTranslit = mlTrans,
            category = "Regular Practice & Discipline",
            emoji = listOf("⏳", "✍️", "🎻", "🏹", "📖", "🏃", "⚙️")[(i - 276) % 7],
            themeSummary = "Regular daily practice transforms ordinary efforts into extraordinary mastery and wisdom."
        )
    }

    private fun parseScriptAndTranslit(raw: String): Pair<String, String> {
        val parts = raw.split(" (")
        val script = parts[0]
        val translit = parts.getOrNull(1)?.removeSuffix(")") ?: script
        return script to translit
    }
}
