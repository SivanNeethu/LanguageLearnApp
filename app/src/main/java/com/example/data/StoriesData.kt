package com.example.data

object StoriesData {

    val categories: List<String> = StoryCatalogueData.allCategories

    private val titlesData = listOf(
        // Panchatantra (1-25)
        Triple("The Thirsty Crow", "प्यासा कौआ (Pyaasa Kauwa)", "ಬಾಯಾರಿದ ಕಾಗೆ (Baayarida Kaage)"),
        Triple("The Lion and the Clever Mouse", "शेर और छोटा चूहा (Sher aur Chhota Chooha)", "ಸಿಂಹ ಮತ್ತು ಚುರುಕು ಇಲಿ (Simha mattu Churuku Ili)"),
        Triple("The Hare and the Tortoise", "खरगोश और कछुआ (Khargosh aur Kachhua)", "ಮೊಲ ಮತ್ತು ಆಮೆ (Mola mattu Aame)"),
        Triple("The Monkey and the Crocodile", "बंदर और मगरमच्छ (Bandar aur Magarmachh)", "ಮಂಗ ಮತ್ತು ಮೊಸಳೆ (Manga mattu Mosale)"),
        Triple("The Blue Jackal", "नीला सियार (Neela Siyaar)", "ನೀಲಿ ನರಿ (Neeli Nari)"),
        Triple("The Fox and the Sour Grapes", "लोमड़ी और खट्टे अंगूर (Lomdi aur Khatte Angoor)", "ನರಿ ಮತ್ತು ಹುಳಿ ದ್ರಾಕ್ಷಿ (Nari mattu Huli Draakshi)"),
        Triple("The Four Faithful Friends", "चार पक्के दोस्त (Chaar Pakke Dost)", "ನಾಲ್ಕು ಆಪ್ತ ಸ್ನೇಹಿತರು (Naalku Aapta Snehitaru)"),
        Triple("The Ant and the Dove", "चींटी और कबूतर (Cheenti aur Kabootar)", "ಇರುವೆ ಮತ್ತು ಪಾರಿವಾಳ (Iruve mattu Paarivaala)"),
        Triple("The Golden Egg Goose", "सोने का अंडा देने वाली हंसिनी (Sone ka Anda Dene Waali Hansini)", "ಚಿನ್ನದ ಮೊಟ್ಟೆಯಿಡುವ ಬಾತುಕೋಳಿ (Chinnada Motteyiduva Baatukoli)"),
        Triple("The Two Silly Goats", "दो नादान बकरियां (Do Naadan Bakriyaan)", "ಎರಡು ಮೊಂಡು ಆಡುಗಳು (Eradu Mondu Aadugalu)"),
        Triple("The Brahmin and the Crooks", "ब्राह्मण और तीन ठग (Brahmin aur Teen Thag)", "ಬ್ರಾಹ್ಮಣ ಮತ್ತು ಮೂವರು ವಂಚಕರು (Brahmana mattu Moovaru Vanchakaru)"),
        Triple("The Crane and the Crab", "बगुला और केकड़ा (Bagula aur Kekda)", "ಕೊಕ್ಕರೆ ಮತ್ತು ಏಡಿ (Kokkare mattu Aedi)"),
        Triple("The Talkative Tortoise", "बातूनी कछुआ (Baatooni Kachhua)", "ವಾಚಾಳಿ ಆಮೆ (Vaachaali Aame)"),
        Triple("The Mouse Maiden", "चूहिया की बेटी (Choohiya ki Beti)", "ಇಲಿಯ ಮಗಳು (Iliya Magalu)"),
        Triple("The Foolish Donkey in Lion's Skin", "शेर की खाल में गधा (Sher ki Khaal me Gadha)", "ಸಿಂಹದ ಚರ್ಮದಲ್ಲಿ ಕತ್ತೆ (Simhada Charmadalli Katte)"),
        Triple("The Sparrows and the Elephant", "चिड़िया और घमंडी हाथी (Chidiya aur Ghamandi Haathi)", "ಗುಬ್ಬಚ್ಚಿಗಳು ಮತ್ತು ಮದ್ದಾನೆ (Gubbachigalu mattu Maddaane)"),
        Triple("The Loyal Mongoose", "वफादार नेवला (Wafaadaar Nevla)", "ನಿಷ್ಠಾವಂತ ಮುಂಗುಸಿ (Nishtaavanta Mungusi)"),
        Triple("The Crows and the Serpent", "कौआ और काला सांप (Kauwa aur Kaala Saanp)", "ಕಾಗೆಗಳು ಮತ್ತು ಕೃಷ್ಣಸರ್ಪ (Kaagegalu mattu Krishna Sarpa)"),
        Triple("The Lion and the Wise Hare", "शेर और चतुर खरगोश (Sher aur Chatur Khargosh)", "ಸಿಂಹ ಮತ್ತು ಬುದ್ಧಿವಂತ ಮೊಲ (Simha mattu Buddhivanta Mola)"),
        Triple("The Hunter and the Pigeons", "शिकारी और कबूतरों का जाल (Shikaari aur Kabootaron ka Jaal)", "ಬೇಟೆಗಾರ ಮತ್ತು ಪಾರಿವಾಳಗಳ ಬಲೆ (Betegaara mattu Paarivaalagala Bale)"),
        Triple("The Camel and the Jackal", "ऊंट और सियार की दावत (Oont aur Siyaar ki Daawat)", "ಒಂಟೆ ಮತ್ತು ನರಿಯ ಔತಣ (Onte mattu Nariya Outana)"),
        Triple("The Musical Donkey", "गाना गाने वाला गधा (Gaana Gaane Waala Gadha)", "ಹಾಡುಗಾರ ಕತ್ತೆ (Haadugaara Katte)"),
        Triple("The Golden Swan and Feather", "सोने के पंख वाला हंस (Sone ke Pankh waala Hans)", "ಚಿನ್ನದ ಗರಿಯ ಹಂಸ (Chinnada Gariya Hamsa)"),
        Triple("The Jackal and the War Drum", "सियार और नगाड़ा (Siyaar aur Nagaada)", "ನರಿ ಮತ್ತು ನಗಾರಿ (Nari mattu Nagaari)"),
        Triple("The Frog King and the Snake", "मेंढक राजा और सांप (Mendhak Raja aur Saanp)", "ಕಪ್ಪೆಗಳ ರಾಜ ಮತ್ತು ಹಾವು (Kappegala Raaja mattu Haavu)"),

        // Akbar & Birbal (26-45)
        Triple("Birbal's Khichdi", "बीरबल की खिचड़ी (Birbal ki Khichdi)", "ಬೀರಬಲ್ಲನ ಖಿಚಡಿ (Beeraballana Khichadi)"),
        Triple("Counting the Crows in the Kingdom", "राज्य के कौवे गिनना (Rajya ke Kauwe Ginna)", "ರಾಜ್ಯದ ಕಾಗೆಗಳ ಲೆಕ್ಕ (Raajyada Kaagegala Lekka)"),
        Triple("The Clever Thief and the Straw", "चोर की दाढ़ी में तिनका (Chor ki Daadhi me Tinka)", "ಗಳ್ಳನ ಗಡ್ಡದಲ್ಲಿ ಕಡ್ಡಿ (Gallana Gaddadalli Kaddi)"),
        Triple("The Pot of Pure Wisdom", "अकल का घड़ा (Akal ka Ghada)", "ಬುದ್ಧಿಯ ಮಡಕೆ (Buddhiya Madake)"),
        Triple("The Well Water Dispute", "कुएं के पानी का झगड़ा (Kuen ke Paani ka Jhagda)", "ಬಾವಿಯ ನೀರಿನ ವ್ಯಾಜ್ಯ (Baaviya Neerina Vyaajya)"),
        Triple("The Golden Mango Tree Witness", "आम के पेड़ की गवाही (Aam ke Ped ki Gawaahi)", "ಮಾವಿನ ಮರದ ಸಾಕ್ಷಿ (Maavina Marada Saakshi)"),
        Triple("Birbal and the Short Stick", "जादुई छड़ी और चोर (Jaadui Chhadi aur Chor)", "ಮಾಯಾದಂಡ ಮತ್ತು ಕಳ್ಳ (Maayadanda mattu Kalla)"),
        Triple("The Emperor's Dream", "बादशाह का सपना (Baadshah ka Sapna)", "ಚಕ್ರವರ್ತಿಯ ಕನಸು (Chakravarthiya Kanasu)"),
        Triple("The Honest Sweet Seller", "हलवाई का सिक्का (Halwaai ka Sikka)", "ಸಿಹಿ ವ್ಯಾಪಾರಿಯ ನಾಣ್ಯ (Seehi Vyaapaariya Naanya)"),
        Triple("Birbal's Beautiful Painting", "बीरबल की सबसे सुंदर तस्वीर (Birbal ki Sabse Sundar Tasveer)", "ಬೀರಬಲ್ಲನ ಅಂದದ ಚಿತ್ರ (Beeraballana Andada Chitra)"),
        Triple("The Heavy Burden of Worry", "चिंता का भारी बोझ (Chinta ka Bhaari Bojh)", "ಚಿಂತೆಯ ಭಾರ (Chinteya Bhaara)"),
        Triple("The Brahmin's Cold Night Test", "ठंडे पानी की परीक्षा (Thande Paani ki Pareeksha)", "ತಣ್ಣೀರಿನ ಪರೀಕ್ಷೆ (Tanneerina Pareekshe)"),
        Triple("Who is the Most Beautiful Baby?", "संसार का सबसे सुंदर बच्चा (Sansaar ka Sabse Sundar Bachha)", "ಲೋಕದ ಅತ್ಯಂತ ಸುಂದರ ಮಗು (Lokada Atyanta Sundara Magu)"),
        Triple("Birbal Catches the Diamond Thief", "हीरे का असली चोर (Heere ka Asli Chor)", "ವಜ್ರದ ಅಸಲಿ ಕಳ್ಳ (Vajrada Asali Kalla)"),
        Triple("The Farmer and the Greedy Moneylender", "किसान और लालची साहुकार (Kisaan aur Laalchi Saahukaar)", "ರೈತ ಮತ್ತು ಜಿಪುಣ ಲೇವಾದೇವಿದಾರ (Raita mattu Jipuna Levaadevidaara)"),
        Triple("The Language of Birds", "पक्षियों की बोली (Pakshiyon ki Boli)", "ಪಕ್ಷಿಗಳ ಭಾಷೆ (Pakshigala Bhaashe)"),
        Triple("The Three Questions of the Sage", "ज्ञानी के तीन कठिन सवाल (Gyaani ke Teen Kathin Sawaal)", "ಜ್ಞಾನಿಯ ಮೂರು ಕಠಿಣ ಪ್ರಶ್ನೆಗಳು (Jnaaniya Mooru Kathina Prashnegalu)"),
        Triple("How Many Turns in the River?", "नदी के कितने मोड़? (Nadi ke Kitne Mod?)", "ನದಿಯ ತಿರುವುಗಳು ಎಷ್ಟು? (Nadiya Tiruvugalu Eshtu?)"),
        Triple("The Emperor's Ring in the Courtyard", "दरबार में खोई अंगूठी (Darbaar me Khoi Angoothi)", "ಸಭೆಯಲ್ಲಿ ಕಳೆದುಹೋದ ಉಂಗುರ (Sabheyalli Kaleduhoda Ungura)"),
        Triple("Birbal's Blind People Census", "अंधों की सूची (Andhon ki Soochi)", "ಕುರುಡರ ಪಟ್ಟಿ (Kurudara Patti)"),

        // Tenali Rama (46-65)
        Triple("Tenali Rama and the Thieves", "तेनाली राम और कुएं के चोर (Tenali Ram aur Kuen ke Chor)", "ತೆನಾಲಿ ರಾಮ ಮತ್ತು ಬಾವಿಯ ಕಳ್ಳರು (Tenali Rama mattu Baaviya Kallaru)"),
        Triple("The Black Dog into White Cow", "काले कुत्ते को गाय बनाना (Kaale Kutte ko Gaay Banaana)", "ಕಪ್ಪು ನಾಯಿಯನ್ನು ಬಿಳಿ ಹಸುವಾಗಿಸುವುದು (Kappu Naayiyannu Bili Hasuvaagisuvudu)"),
        Triple("The Cat that Feared Warm Milk", "दूध से डरने वाली बिल्ली (Doodh se Darne Waali Billi)", "ಹಾಲಿಗೆ ಹೆದರುವ ಬೆಕ್ಕು (Haalige Hedaruvad Bekku)"),
        Triple("Tenali Rama's Blank Canvas", "तेनाली राम की अदृश्य पेंटिंग (Tenali Ram ki Adrishya Painting)", "ತೆನಾಲಿ ರಾಮನ ಖಾಲಿ ಚಿತ್ರ (Tenali Ramana Khaali Chitra)"),
        Triple("The Brinjal from the Royal Garden", "शाही बैंगन की चोरी (Shaahi Baingan ki Chori)", "ರಾಜ ತೋಟದ ಬದನೆಕಾಯಿ (Raaja Totada Badanekayi)"),
        Triple("The Greatest Fool in the City", "विजयनगर का सबसे बड़ा मूर्ख (Vijayanagar ka Sabse Bada Moorkh)", "ನಗರದ ಮಹಾ ಮೂರ್ಖ (Nagarada Maha Moorkha)"),
        Triple("Tenali Rama and the Clay Pot", "सिर पर मिट्टी की हांडी (Sir par Mitti ki Haandi)", "ತಲೆಯ ಮೇಲಿನ ಮಣ್ಣಿನ ಮಡಕೆ (Taleya Melina Mannina Madake)"),
        Triple("The Horse that Ate Nothing", "घास न खाने वाला घोड़ा (Ghaas na Khaane Waala Ghoda)", "ಹುಲ್ಲು ತಿನ್ನದ ಕುದುರೆ (Hullu Tinnada Kudure)"),
        Triple("The Golden Offering to Priests", "सोने के आम का दान (Sone ke Aam ka Daan)", "ಚಿನ್ನದ ಮಾವಿನಹಣ್ಣಿನ ದಾನ (Chinnada Maavina Hannina Daana)"),
        Triple("The Weaver and the Invisible Shawl", "जादुई अदृश्य शॉल (Jaadui Adrishya Shawl)", "ಕಾಣದ ಮಾಯಾ ಶಾಲು (Kaanada Maaya Shaalu)"),
        Triple("Tenali Rama and the Proud Scholar", "घमंडी पंडित की हार (Ghamandi Pandit ki Haar)", "ಅಹಂಕಾರಿ ಪಂಡಿತನ ಸೋಲು (Ahamkaari Panditana Solu)"),
        Triple("The Yard of Smoke Measurement", "धुएं का नाप (Dhuen ka Naap)", "ಹೊಗೆಯ ಅಳತೆ (Hogeya Alathe)"),
        Triple("The Goddess and the Sneeze", "काली माँ और तेनाली की हंसी (Kaali Maa aur Tenali ki Hansi)", "ಕಾಳಿ ಮಾತೆ ಮತ್ತು ರಾಮನ ನಗು (Kaali Maate mattu Ramana Nagu)"),
        Triple("Tenali Rama's Three Conditions", "तेनाली राम की तीन शर्तें (Tenali Ram ki Teen Shartein)", "ತೆನಾಲಿ ರಾಮನ ಮೂರು ಷರತ್ತುಗಳು (Tenali Ramana Mooru Sharattugalu)"),
        Triple("The Mystery of the Stolen Blanket", "चुराया हुआ गरम कंबल (Churaaya hua Garam Kambal)", "ಕಳವಾದ ಕಂಬಳಿ (Kalavaada Kambali)"),
        Triple("The Royal Elephant's Golden Tooth", "हाथी का सोने का दांत (Haathi ka Sone ka Daant)", "ಆನೆಯ ಚಿನ್ನದ ಹಲ್ಲು (Aaneya Chinnada Hallu)"),
        Triple("Tenali Rama and the Greedy Astrologer", "लालची ज्योतिषी की भविष्यवाणी (Laalchi Jyotishi ki Bhavishyavaani)", "ದುರಾಶೆಯ ಜ್ಯೋತಿಷಿ (Duraasheya Jyotishi)"),
        Triple("The Mirror of True Character", "सच्चे चरित्र का आईना (Sachhe Charitra ka Aaina)", "ಗುಣದ ಕನ್ನಡಿ (Gunada Kannadi)"),
        Triple("Tenali's Clever Boundary Stone", "खेत की सीमा का पत्थर (Khet ki Seema ka Patthar)", "ಗದ್ದೆಯ ಗಡಿಗಲ್ಲು (Gaddeya Gadigallu)"),
        Triple("The King's Smile Reward", "महाराज की मुस्कान (Maharaj ki Muskaan)", "ಮಹಾರಾಜರ ಮಂದಹಾಸ (Mahaaraajara Mandahaasa)"),

        // Jataka Tales & Moral Fables (66-85)
        Triple("The Golden Deer of the Forest", "सुनहरा हिरन (Sunahra Hiran)", "ಚಿನ್ನದ ಜಿಂಕೆ (Chinnada Jinke)"),
        Triple("The Honest Woodcutter and Axe", "ईमानदार लकड़हारा और कुल्हाड़ी (Imaandaar Lakadhara aur Kulhaadi)", "ಪ್ರಾಮಾಣಿಕ ಕಟ್ಟಿಗೆ ಕಡಿಯುವವನು (Praamaanika Kattige Kadiyuvavanu)"),
        Triple("The Grateful Elephant and Little Dog", "हाथी और नन्हे पिल्ले की दोस्ती (Haathi aur Nanhe Pille ki Dosti)", "ಆನೆ ಮತ್ತು ನಾಯಿಮರಿಯ ಸ್ನೇಹ (Aane mattu Naayimariya Sneha)"),
        Triple("The Brave Little Quail", "बहादुर नन्ही बटेर (Bahaadur Nanhi Bater)", "ಧೀರ ಪುಟ್ಟ ಲಾವಕ್ಕಿ (Dheera Putta Laavakki)"),
        Triple("The Golden Swan of Compassion", "दयालु सुनहरा हंस (Dayaalu Sunahra Hans)", "ಕರುಣಾಮಯಿ ಚಿನ್ನದ ಹಂಸ (Karunaamayi Chinnada Hamsa)"),
        Triple("The Merchant of Pure Gold", "सच्चा और बेईमान व्यापारी (Sachha aur Beimaan Vyaapaari)", "ಪ್ರಾಮಾಣಿಕ ಚಿನ್ನದ ವ್ಯಾಪಾರಿ (Praamaanika Chinnada Vyaapaari)"),
        Triple("The Banyan Deer's Sacrifice", "बरगद के हिरन का त्याग (Bargad ke Hiran ka Tyaag)", "ಆಲದ ಜಿಂಕೆಯ ತ್ಯಾಗ (Aalada Jinkeya Tyaaga)"),
        Triple("The Monkey King's Bridge", "वानर राज का पुल (Vaanar Raaj ka Pul)", "ವಾನರ ರಾಜನ ಸೇತುವೆ (Vaanara Raajana Setuve)"),
        Triple("The Little Pigeon and Crow", "कबूतर और लोभी कौआ (Kabootar aur Lobhi Kauwa)", "ಪಾರಿವಾಳ ಮತ್ತು ದುರಾಶೆಯ ಕಾಗೆ (Paarivaala mattu Duraasheya Kaage)"),
        Triple("The Ox That Won the Wager", "मेहनती बैल की जीत (Mehnati Bail ki Jeet)", "ಪ್ರಾಮಾಣಿಕ ಎತ್ತಿನ ಜಯ (Praamaanika Ettina Jaya)"),
        Triple("The King Who Kept His Promise", "वचन निभाने वाला राजा (Vachan Nibhaane Waala Raja)", "ಮಾತು ಉಳಿಸಿಕೊಂಡ ರಾಜ (Maatu Ulishikonda Raaja)"),
        Triple("The Wise Old Parakeet", "बुजुर्ग तोते की सलाह (Bujurg Tote ki Salaah)", "ಹಿರಿಯ ಗಿಳಿಯ ಹಿತನುಡಿ (Hiriya Giliya Hitanudi)"),
        Triple("The Sandy Desert Journey", "रेगिस्तान का साहसी सफर (Registaan ka Saahasi Safar)", "ಮರಳುಗಾಡಿನ ಧೈರ್ಯಶಾಲಿ ಪಯಣ (Maralugaadina Dhairyashaali Payana)"),
        Triple("The Lake of Serenity", "शांत सरोवर की सीख (Shaant Sarovar ki Seekh)", "ಪ್ರಶಾಂತ ಸರೋವರ (Prashaanta Sarovara)"),
        Triple("The Lion and the Humble Jackal", "शेर और कृतज्ञ सियार (Sher aur Kritagya Siyaar)", "ಸಿಂಹ ಮತ್ತು ಕೃತಜ್ಞ ನರಿ (Simha mattu Kritajna Nari)"),
        Triple("The Tree Spirit's Blessing", "वृक्ष देवता का आशीर्वाद (Vriksh Devta ka Aasheervaad)", "ವೃಕ್ಷ ದೇವತೆಯ ವರ (Vriksha Devateya Vara)"),
        Triple("The Blind Vulture and Cat", "अंधा गिद्ध और बिल्ली (Andha Giddh aur Billi)", "ಕುರುಡು ರಣಹದ್ದು ಮತ್ತು ಬೆಕ್ಕು (Kurudu Ranahaddu mattu Bekku)"),
        Triple("The Two Otters and the Jackal", "दो ऊदबिलाव और मछली (Do Oodbilaav aur Machhli)", "ಎರಡು ನೀರುನಾಯಿಗಳು ಮತ್ತು ನರಿ (Eradu Neerunaayigalu mattu Nari)"),
        Triple("The True Mirror of Heart", "निर्मल मन का आईना (Nirmal Man ka Aaina)", "ಶುದ್ಧ ಮನಸ್ಸಿನ ಪ್ರತಿಬಿಂಬ (Shuddha Manassina Pratibimba)"),
        Triple("The King and the Gardener", "राजा और सच्चा माली (Raja aur Sachha Maali)", "ರಾಜ ಮತ್ತು ನಿಸ್ವಾರ್ಥ ತೋಟಗಾರ (Raaja mattu Nisvaartha Totagaara)"),

        // Hitopadesha & Indian Folk Fables (86-100)
        Triple("Unity of the Mountain Pigeons", "पहाड़ी कबूतरों की एकता (Pahaadi Kabootaron ki Ekta)", "ಬೆಟ್ಟದ ಪಾರಿವಾಳಗಳ ಐಕ್ಯತೆ (Bettada Paarivaalagala Aikyate)"),
        Triple("The Old Tiger and the Gold Bangle", "बूढ़ा बाघ और सोने का कंगन (Boodha Baagh aur Sone ka Kangan)", "ಮುದಿಯ ಹುಲಿ ಮತ್ತು ಚಿನ್ನದ ಬಳೆ (Mudiya Huli mattu Chinnada Bale)"),
        Triple("The Mouse Who Befriended the Crow", "चूहे और कौवे की सच्ची मित्रता (Choohe aur Kauwe ki Sachhi Mitrata)", "ಇಲಿ ಮತ್ತು ಕಾಗೆಯ ಸತ್ಯ ಸ್ನೇಹ (Ili mattu Kaageya Satya Sneha)"),
        Triple("The Blue Heron's Feast", "बगुले की चतुराई (Bagule ki Chaturaai)", "ಬೆಳ್ಳಕ್ಕಿಯ ಚಾತುರ್ಯ (Bellakkiya Chaaturya)"),
        Triple("The Magic Cooking Pot", "जादुई हांडी (Jaadui Haandi)", "ಮಾಯಾ ಮಡಕೆ (Maaya Madake)"),
        Triple("The Shepherd Boy and Wolf", "गड़ेरिया और भेड़िया (Gaderiya aur Bhediya)", "ಕುರುಬ ಹುಡುಗ ಮತ್ತು ತೋಳ (Kuruba Huduga mattu Tola)"),
        Triple("The Potter Who Became a Warrior", "कुम्हार जो सेनापति बना (Kumhaar jo Senapati Bana)", "ಕುಂಬಾರನ ಸಾಹಸ (Kumbaarana Saahasa)"),
        Triple("The King and the Spider's Web", "राजा और मकड़ी का जाला (Raja aur Makdi ka Jaala)", "ರಾಜ ಮತ್ತು ಜೇಡರ ಬಲೆ (Raaja mattu Jedara Bale)"),
        Triple("The Little Girl and the Star Jar", "नन्ही गुड़िया और चमकते तारे (Nanhi Gudiya aur Chamakte Taare)", "ಪುಟ್ಟ ಬಾಲಕಿ ಮತ್ತು ನಕ್ಷತ್ರಗಳು (Putta Baalaki mattu Nakshatragalu)"),
        Triple("The River That Learned to Share", "परोपकारी नदी की धारा (Paropkaari Nadi ki Dhaara)", "ಹಂಚಿ ಹರಿದ ಪುಣ್ಯ ನದಿ (Hanchi Harida Punya Nadi)"),
        Triple("The Tree That Gave Everything", "सब कुछ देने वाला कल्पवृಕ್ಷ (Sab Kuchh Dene Waala Kalpavriksh)", "ಸರ್ವಸ್ವವನ್ನೂ ನೀಡಿದ ವೃಕ್ಷ (Sarvasvavannu Needida Vriksha)"),
        Triple("The Glowworm's Humble Light", "जुगनू का नन्हा प्रकाश (Jugnu ka Nanha Prakash)", "ಮಿಂಚುಹುಳುವಿನ ಬೆಳಕು (Minchuhuluvina Belaku)"),
        Triple("The Flute of Peace in the Valley", "शांति की मधुर बांसुरी (Shanti ki Madhur Baansuri)", "ಶಾಂತಿಯ ಕೊಳಲು (Shaantiya Kolalu)"),
        Triple("The Sunflower and the Rain Cloud", "सूरजमुखी और बरसता बादल (Soorajmukhi aur Barasta Baadal)", "ಸೂರ್ಯಕಾಂತಿ ಮತ್ತು ಮಳೆಮೋಡ (Sooryakaanti mattu Malemoda)"),
        Triple("The Circle of Generous Kindness", "निःस्वार्थ भलाई का चक्र (Nihswaarth Bhalaai ka Chakra)", "ಉದಾರ ಉಪಕಾರದ ವೃತ್ತ (Udaara Upakaarada Vritta)")
    )

    // Curated rich stories with complete multi-paragraph narrative for deep 10-min read & speak
    private val detailedStorySamples = mapOf(
        1 to listOf(
            StoryParagraph(
                1,
                "एक बहुत गर्म दोपहर थी। एक प्यासा कौआ पानी की तलाश में दूर-दूर तक उड़ रहा था। गर्मी से उसका गला सूख रहा था।",
                "Ek bahut garam dopahar thi. Ek pyaasa kauwa paani ki talaash me door-door tak ud raha tha. Garmi se uska gala sookh raha tha.",
                "ಒಂದು ದಿನ ತುಂಬಾ ಬಿಸಿಲಿನ ಮಧ್ಯಾಹ್ನವಾಗಿತ್ತು. ಬಾಯಾರಿದ ಕಾಗೆಯೊಂದು ನೀರಿಗಾಗಿ ದೂರದವರೆಗೆ ಹಾರಾಡುತ್ತಿತ್ತು. ಬಿಸಿಲಿಗೆ ಅದರ ಗಂಟಲು ಒಣಗಿಹೋಗಿತ್ತು.",
                "Ondu dina tumba bisilina madhyaahnavaagittu. Baayarida kaageyondu neerigaagi dooradavarege haaraaduttittu. Bisilige adara gantalu onagihogittu.",
                "It was a scorching hot summer afternoon. A thirsty crow flew across the fields in search of water. His throat was completely dry from the heat.",
                "നല്ല ചൂടുള്ള ഒരു വേനൽക്കാല ഉച്ചയായിരുന്നു. ദാഹിച്ച ഒരു കാക്ക വെള്ളം തേടി ദൂരേക്ക് പറന്നു. ചൂടുകൊണ്ട് അതിന്റെ തൊണ്ട വല്ലാതെ വരണ്ടിരുന്നു.",
                "Nalla choodulla oru venalkaala uchhayaayirunnu. Daahicha oru kaakka vellam thedi doorekku parannu. Choodukondu athinte thonda vallaathe varandirunnu."
            ),
            StoryParagraph(
                2,
                "उड़ते-उड़ते उसे एक सुंदर बगीचे में एक मिट्टी का घड़ा दिखाई दिया। कौआ खुशी-खुशी घड़े के पास गया। उसने अंदर झाँककर देखा।",
                "Udte-udte use ek sundar bageeche me ek mitti ka ghada dikhai diya. Kauwa khushi-khushi ghade ke paas gaya. Usne andar jhaank-kar dekha.",
                "ಹಾರುತ್ತಾ ಹಾರುತ್ತಾ ಅದಕ್ಕೆ ಒಂದು ಸುಂದರ ತೋಟದಲ್ಲಿ ಮಣ್ಣಿನ ಕೊಡ ಕಣ್ಣಿಗೆ ಬಿತ್ತು. ಕಾಗೆ ಸಂತೋಷದಿಂದ ಕೊಡದ ಬಳಿ ಹೋಯಿತು. ಒಳಗೆ ಇಣುಕಿ ನೋಡಿತು.",
                "Haaruttaa haaruttaa adakke ondu sundara totadalli mannina koda kannige bittu. Kaage santosshadinda kodada bali hoyitu. Olage inuki noditu.",
                "As he flew, he spotted an earthen pitcher in a shady garden. Overjoyed, the crow landed beside it and peered inside eagerly.",
                "അങ്ങനെ പറക്കുമ്പോൾ ഒരു സുന്ദരമായ തോട്ടത്തിൽ ഒരു മൺകലം കണ്ടു. കാക്ക സന്തോഷത്തോടെ കലത്തിന്റെ അടുത്തെത്തി ഉള്ളിലേക്ക് നോക്കി.",
                "Angane parakkumpol oru sundaramaaya thottathil oru mankalam kandu. Kaakka santhoshathode kalathinte aduthethi ullilekku nokki."
            ),
            StoryParagraph(
                3,
                "घड़े में पानी बहुत नीचे था। कौए की चोंच पानी तक नहीं पहुँच पा रही थी। उसने सोचा, 'अगर मैं हार मान लूँगा, तो प्यासा ही रह जाऊँगा।' उसने धैर्य से काम लिया।",
                "Ghade me paani bahut neeche tha. Kauwe ki chonch paani tak nahi pahunch pa rahi thi. Usne socha, 'Agar main haar maan loonga, to pyaasa hi rah jaoonga.' Usne dhairya se kaam liya.",
                "ಕೊಡದಲ್ಲಿ ನೀರು ತೀರಾ ಕೆಳಗಿತ್ತು. ಕಾಗೆಯ ಕೊಕ್ಕು ನೀರಿಗೆ ತಲುಪುತ್ತಿರಲಿಲ್ಲ. 'ನಾನು ಸುಮ್ಮನೆ ಬಿಟ್ಟರೆ ಬಾಯಾರಿಕೆಯಿಂದ ಬಳಲಬೇಕಾಗುತ್ತದೆ' ಎಂದು ಯೋಚಿಸಿ, ಧೈರ್ಯದಿಂದ ಒಂದು ಉಪಾಯ ಹುಡುಕಿತು.",
                "Kodadalli neeru teera kelagittu. Kaageya kokku neerige taluputtiralilla. 'Naanu summane bittare baayaarikeyinda balalabekaaguttade' endu yochisi, dhairyadinda ondu upaaya hudukitu.",
                "The water level was too low at the bottom. His beak could not reach it. He said to himself, 'I must not give up, I must find a clever way.'",
                "കലത്തിൽ വെള്ളം വളരെ താഴെയായിരുന്നു. കാക്കയുടെ കൊക്ക് വെള്ളത്തിലേക്ക് എത്തിയില്ല. എന്നാൽ അത് തോറ്റുകൊടുക്കാൻ തയ്യാറായില്ല, ഒരു ഉപായം ആലോചിച്ചു.",
                "Kalathil vellam valare thaazheyaayirunnu. Kaakkayude kokku vellathilekku ethiyilla. Ennaal athu thottukodukkaan thayyaaraayilla, oru upaayam aalochichu."
            ),
            StoryParagraph(
                4,
                "तभी उसकी नज़र पास पड़े छोटे-छोटे कंकड़ों पर पड़ी। उसे एक बढ़िया उपाय सूझा! कौए ने एक-एक करके कंकड़ अपनी चोंच में उठाए और घड़े में डालने लगा।",
                "Tabhi uski nazar paas pade chhote-chhote kankadon par padi. Use ek badhiya upaay soojha! Kauwe ne ek-ek karke kankad apni chonch me uthaaye aur ghade me daalne laga.",
                "ತಕ್ಷಣ ಅದರ ಕಣ್ಣು ಸಮೀಪದಲ್ಲಿದ್ದ ಸಣ್ಣ ಸಣ್ಣ ಬೆಣಚುಕಲ್ಲುಗಳ ಮೇಲೆ ಬಿತ್ತು. ಕಾಗೆಗೆ ಅದ್ಭುತ ಉಪಾಯ ಹೊಳೆಯಿತು! ಒಂದೊಂದೇ ಕಲ್ಲನ್ನು ಕೊಕ್ಕಿನಲ್ಲಿ ಹೆಕ್ಕಿ ಕೊಡದೊಳಗೆ ಹಾಕತೊಡಗಿತು.",
                "Takshana adara kannu sameepadallidda sanna sanna benachukallugala mele bittu. Kaagege adbhuta upaaya holeyitu! Ondonde kallannu kokkinalli hekki kodadolage haakatodagitu.",
                "Nearby, he noticed small shiny pebbles scattered on the ground. A brilliant idea struck him! He began picking up pebbles one by one and dropping them into the pitcher.",
                "അപ്പോഴാണ് അടുത്തു കിടന്ന ചെറിയ ഉരുളൻ കല്ലുകൾ കാക്കയുടെ കണ്ണിൽ പെട്ടത്. അതിന് നല്ലൊരു ബുദ്ധി തോന്നി! ഓരോ കല്ലുകളായി കൊക്കിലെടുത്ത് കലത്തിലേക്ക് ഇടാൻ തുടങ്ങി.",
                "Appozhaanu aduthu kidanna cheriya urulan kallukal kaakkayude kannil pettathu. Athinu nalloru buddhi thonni! Ooro kallukalaayi kokkileduthu kalathilekku idaan thudangi."
            ),
            StoryParagraph(
                5,
                "जैसे-जैसे कंकड़ नीचे बैठते गए, पानी धीरे-धीरे ऊपर आने लगा। कौए ने तब तक मेहनत की जब तक पानी घड़े के मुँह तक नहीं आ गया।",
                "Jaise-jaise kankad neeche baith-te gaye, paani dheere-dheere oopar aane laga. Kauwe ne tab tak mehnat ki jab tak paani ghade ke munh tak nahi aa gaya.",
                "ಕಲ್ಲುಗಳು ಕೆಳಗೆ ಕುಳಿತಂತೆಲ್ಲಾ, ನೀರು ನಿಧಾನವಾಗಿ ಮೇಲಕ್ಕೆ ಬರಲಾರಂಭಿಸಿತು. ಕಾಗೆ ದಣಿವರಿಯದೆ ನೀರು ಕಂಠದವರೆಗೆ ಬರುವವರೆಗೂ ಕಲ್ಲುಗಳನ್ನು ಹಾಕಿತು.",
                "Kallugalu kelage kulitantellaa, neeru nidhaanavaagi melakke baralaarambhisitu. Kaage danivariyade neeru kanthadavaregoo kallugalannu haakitu.",
                "As the pebbles filled the base, the water rose gradually. The persistent crow worked tirelessly until the sparkling water reached the very rim.",
                "കല്ലുകൾ താഴെ നിറഞ്ഞതോടെ വെള്ളം പതുക്കെ മുകളിലേക്ക് ഉയർന്നു വന്നു. വെള്ളം കലത്തിന്റെ വക്ക് വരെ എത്തുന്നതുവരെ കാക്ക കഠിനാധ്വാനം ചെയ്തു.",
                "Kallukal thaazhe niranajathode vellam pathukke mukalilekku uyarnnu vannu. Vellam kalathinte vakku vare ethunnathuvare kaakka kathinaadhwaanam cheythu."
            ),
            StoryParagraph(
                6,
                "कौए ने जी भरकर ठंडा-मीठा पानी पिया। उसकी प्यास बुझ गई और उसमें नई ताज़गी आ गई। वह खुशी से काँव-काँव करता हुआ नीले आसमान में उड़ गया।",
                "Kauwe ne jee bhar-kar thanda-meetha paani piya. Uski pyaas bujh gayi aur usme nayi taazgi aa gayi. Wah khushi se kaanw-kaanw karta hua neele aasmaan me ud gaya.",
                "ಕಾಗೆ ತೃಪ್ತಿಯಾಗಿ ತಣ್ಣನೆಯ ನೀರನ್ನು ಕುಡಿಯಿತು. ಅದರ ದಾಹ ತೀರಿತು ಮತ್ತು ಮೈಮನಸ್ಸುಗಳು ಚೈತನ್ಯದಿಂದ ತುಂಬಿದವು. ಸಂತೋಷದಿಂದ ಕಾ-ಕಾ ಎನ್ನುತ್ತಾ ಮುಗಿಲಿಗೆ ಹಾರಿಹೋಯಿತು.",
                "Kaage truptiyaagi tannaneya neerannu kudiyitu. Adara daaha teeritu mattu maimanasugalu chaitanyadinda tumbidavu. Santosshadinda kaa-kaa ennuttaa mugilige haarihoyitu.",
                "The thirsty crow drank the cool, refreshing water to his heart's content. Re-energized and triumphant, he cawed happily and soared high into the bright blue sky.",
                "കാക്ക വയറുനിറയെ തണുത്ത ശുദ്ധജലം കുടിച്ചു. അതിന്റെ ദാഹം തീർന്നു, പുതിയ ഉന്മേഷം തോന്നി. കാ-കാ എന്ന് സന്തോഷത്തോടെ പാടി അത് നീലാകാശത്തിലേക്ക് പറന്നുയർന്നു.",
                "Kaakka vayaruniraye thanutha shuddhajaalam kudichu. Athinte daaham theernnu, puthiya unmesham thonni. Kaa-kaa ennu santhoshathode paadi athu neelaakaashathilekku parannuyarnnu."
            )
        ),

        2 to listOf(
            StoryParagraph(
                1,
                "एक घने जंगल में एक विशाल शेर गहरी नींद में सो रहा था। वह जंगल का पराक्रमी राजा था और सभी जानवर उसका आदर करते थे।",
                "Ek ghane jungle me ek vishaal sher gehri neend me so raha tha. Wah jungle ka paraakrami raja tha aur sabhi jaanwar uska aadar karte the.",
                "ದಟ್ಟವಾದ ಒಂದು ಸುಂದರ ಕಾಡಿನಲ್ಲಿ ಬಲಿಷ್ಠ ಸಿಂಹವೊಂದು ಮರದ ನೆರಳಿನಲ್ಲಿ ಗಾಢವಾಗಿ ನಿದ್ದೆ ಮಾಡುತ್ತಿತ್ತು. ಕಾಡಿನ ಎಲ್ಲಾ ಪ್ರಾಣಿಗಳು ಅದಕ್ಕೆ ಗೌರವ ನೀಡುತ್ತಿದ್ದವು.",
                "Dattavaada ondu sundara kaadinalli balishta simhavondu marada neralinalli gaadavaagi nidde maaduttittu. Kaadina ellaa praanigalu adakke gaurava needuttiddavu.",
                "In a deep green forest, a mighty lion was fast asleep under the cool shade of a great tree. All animals respected his strength."
            ),
            StoryParagraph(
                2,
                "तभी एक नन्हा चूहा वहाँ खेलने आया। वह शेर के शरीर को खेल का मैदान समझकर उसकी पीठ पर कूदने लगा। चूहे की उछलकूद से शेर की नींद टूट गई।",
                "Tabhi ek nanha chooha wahaan khelne aaya. Wah sher ke shareer ko khel ka maidaan samajhkar uski peeth par koodne laga. Choohe ki uchhalkood se sher ki neend toot gayi.",
                "ಅಷ್ಟರಲ್ಲಿ ಪುಟ್ಟ ಇಲಿಯೊಂದು ಅಲ್ಲಿಗೆ ಆಟವಾಡಲು ಬಂದಿತು. ಅದು ಸಿಂಹದ ಬೆನ್ನನ್ನು ಆಟದ ಮೈದಾನವೆಂದು ತಿಳಿದು ಅದರ ಮೇಲೆ ನೆಗೆಯತೊಡಗಿತು. ಇದರಿಂದ ಸಿಂಹದ ನಿದ್ದೆಗೆ ಭಂಗವಾಯಿತು.",
                "Ashtaralli putta iliyondu allige aatavaadalu banditu. Adu simhada bennannu aatada maidaanavendu tilidu adara mele negeyatodagitu. Idarinda simhada niddege bhangavaayitu.",
                "A tiny curious mouse scurried by. Thinking the lion's fur was a soft hill, he hopped playfully onto the lion's back, waking the giant beast."
            ),
            StoryParagraph(
                3,
                "शेर ने गुस्से में दहाड़कर चूहे को अपने भारी पंजे में दबोच लिया। चूहा थर-थर काँपने लगा और बोला, 'हे वनराज! मुझे क्षमा कर दीजिए। क्या पता किसी दिन मैं भी आपकी मदद कर सकूँ!'",
                "Sher ne gusse me dahaadkar choohe ko apne bhaari panje me daboch liya. Chooha thar-thar kaanpne laga aur bola, 'Hey Vanraaj! Mujhe kshama kar deejiye. Kya pata kisi din main bhi aapki madad kar sakoon!'",
                "ಕೋಪಗೊಂಡ ಸಿಂಹವು ಗರ್ಜಿಸಿ ಇಲಿಯನ್ನು ತನ್ನ ದಪ್ಪ ಪಂಜದಲ್ಲಿ ಹಿಡಿಯಿತು. ಇಲಿ ನಡುಗುತ್ತಾ, 'ಮೃಗರಾಜ, ದಯವಿಟ್ಟು ನನ್ನನ್ನು ಕ್ಷಮಿಸಿ! ಎಂದಾದರೂ ಒಂದು ದಿನ ನಾನು ನಿಮಗೆ ನೆರವಾಗಬಹುದು!' ಎಂದು ಬೇಡಿಕೊಂಡಿತು.",
                "Kopagonda simhavu garjisi iliyannu tanna dappa panjadalli hidiyitu. Ili naduguttaa, 'Mrugaraaja, dayavittu nannannu kshamisi! Endaadaru ondu dina naanu nimage neravaagabahudu!' endu bedikonditu.",
                "The lion roared furiously and trapped the mouse under his heavy paw. The trembling mouse pleaded, 'Forgive me, O King! Perhaps one day I may help you in return!'"
            ),
            StoryParagraph(
                4,
                "शेर चूहे की बात सुनकर हँसा, 'तुम इतने छोटे जीव होकर मेरी क्या मदद करोगे?' लेकिन दया करके शेर ने चूहे को छोड़ दिया। चूहे ने सिर झुकाकर धन्यवाद कहा।",
                "Sher choohe ki baat sunkar hansa, 'Tum itne chhote jeev hokar meri kya madad karoge?' Lekin daya karke sher ne choohe ko chhod diya. Choohe ne sir jhukaakar dhanyavaad kaha.",
                "ಸಿಂಹವು ನಕ್ಕು, 'ಇಷ್ಟು ಸಣ್ಣ ಪ್ರಾಣಿ ನೀನು, ನನಗೆ ಹೇಗೆ ಸಹಾಯ ಮಾಡುವೆ?' ಎಂದು ಹಾಸ್ಯವಾಡಿತು. ಆದರೆ ಕರುಣೆ ತೋರಿ ಇಲಿಯನ್ನು ಬಿಟ್ಟುಬಿಟ್ಟಿತು. ಇಲಿ ಧನ್ಯವಾದ ಹೇಳಿ ಓಡಿತು.",
                "Simhavu nakku, 'Ishtu sanna praani neenu, nanage hege sahaaya maaduve?' endu haasyavaaditu. Aadare karune tori iliyannu bittubittitu. Ili dhanyavaada heli oditu.",
                "The lion laughed heartily at the notion of a tiny mouse helping the king of beasts. Yet out of noble kindness, he opened his paw and set the little creature free."
            ),
            StoryParagraph(
                5,
                "कुछ दिनों बाद, जंगल में कुछ शिकारी आए। उन्होंने शेर को फँसाने के लिए एक मजबूत जाल बिछाया। शेर उस जाल में बुरी तरह फँस गया और बेबस होकर दहाड़ने लगा।",
                "Kuchh dinon baad, jungle me kuchh shikaari aaye. Unhone sher ko phansaane ke liye ek mazboot jaal bichhaaya. Sher us jaal me buri tarah phans gaya aur bebas hokar dahaadne laga.",
                "ಕೆಲವು ದಿನಗಳ ನಂತರ ಕಾಡಿಗೆ ಬೇಟೆಗಾರರು ಬಂದರು. ಅವರು ಸಿಂಹವನ್ನು ಹಿಡಿಯಲು ಭದ್ರವಾದ ಹಗ್ಗದ ಬಲೆಯನ್ನು ಹಾಸಿದರು. ಸಿಂಹವು ಬಲೆಯಲ್ಲಿ ಸಿಲುಕಿ ಅಸಹಾಯಕವಾಗಿ ಘರ್ಜಿಸಿತು.",
                "Kelavu dinagala nantara kaadige betegaararu bandaru. Avaru simhavannu hidiyalu bhadravaada haggada baleyannu haasidaru. Simhavu baleyalli siluki asahaayakavaagi gharjisitu.",
                "Days later, royal hunters laid a strong rope trap in the forest. The lion stepped into the snare and was trapped tightly, unable to break free despite mighty roars."
            ),
            StoryParagraph(
                6,
                "शेर की आवाज़ सुनकर वही छोटा चूहा वहाँ दौड़ा आया। उसने बिना डरे अपने तेज़ दाँतों से जाल की रस्सियों को काटना शुरू कर दिया। कुछ ही देर में शेर आज़ाद हो गया!",
                "Sher ki aawaaz sunkar wahi chhota chooha wahaan dauda aaya. Usne bina dare apne tez daanton se jaal ki rassiyon ko kaatna shuru kar diya. Kuchh hi der me sher aazaad ho gaya!",
                "ಆ ಗರ್ಜನೆಯನ್ನು ಕೇಳಿದ ಅದೇ ಪುಟ್ಟ ಇಲಿ ತಕ್ಷಣ ಓಡಿಬಂದಿತು. ಕಿಂಚಿತ್ತೂ ಭಯಪಡದೆ ತನ್ನ ಹರಿತವಾದ ಹಲ್ಲುಗಳಿಂದ ಬಲೆಯ ಹಗ್ಗಗಳನ್ನು ಕತ್ತರಿಸಿತು. ಸಿಂಹವು ಕ್ಷಣಾರ್ಧದಲ್ಲಿ ಬಿಡುಗಡೆಯಾಯಿತು!",
                "Aa garjaneyannu kelida ade putta ili takshana odibanditu. Kinchittoo bhayapadade tanna haritavaada hallugalinda baleya haggagalannu kattarisitu. Simhavu kshanaardhadalli bidugadeyaayitu.",
                "Recognizing the roar, the little mouse rushed to the spot. With his razor-sharp teeth, he gnawed through the ropes without hesitation until the lion stood free!"
            ),
            StoryParagraph(
                7,
                "शेर ने चूहे का आभार माना और दोनों हमेशा के लिए पक्के दोस्त बन गए। शेर ने समझ लिया कि किसी को भी उसके आकार से छोटा नहीं समझना चाहिए।",
                "Sher ne choohe ka aabhaar maana aur dono hamesha ke liye pakke dost ban gaye. Sher ne samajh liya ki kisi ko bhi uske aakaar se chhota nahi samajhna chahiye.",
                "ಸಿಂಹವು ಇಲಿಗೆ ತುಂಬು ಹೃದಯದ ಧನ್ಯವಾದ ತಿಳಿಸಿತು. ಅಂದಿನಿಂದ ಅವರಿಬ್ಬರೂ ಆತ್ಮೀಯ ಸ್ನೇಹಿತರಾದರು. ಯಾರನ್ನೂ ಸಣ್ಣವರೆಂದು ಕಡೆಗಣಿಸಬಾರದು ಎಂಬುದು ಸಿಂಹಕ್ಕೆ ತಿಳಿಯಿತು.",
                "Simhavu ilige tumbu hrudayada dhanyavaada tilisitu. Andininda avaribbaroo aatmeeya snehitaraadaru. Yaarannoo sannavarendu kadeganisabaaradu embudu simhakke tiliyitu.",
                "The humble lion thanked the tiny mouse, and the two remained the best of friends forever. Kindness is never wasted, no matter how small."
            )
        ),

        26 to listOf(
            StoryParagraph(
                1,
                "सर्दियों की एक कड़कड़ाती शाम थी। बादशाह अकबर और बीरबल एक सुंदर झील के किनारे टहल रहे थे। पानी बर्फ जैसा ठंडा था।",
                "Sardiyon ki ek kadkadaati shaam thi. Baadshah Akbar aur Birbal ek sundar jheel ke kinaare tahal rahe the. Paani barf jaisa thanda tha.",
                "ಅದು ಚಳಿಗಾಲದ ತೀವ್ರ ಸಂಜೆಯಾಗಿತ್ತು. ಬಾದಶಾಹ ಅಕ್ಬರ್ ಮತ್ತು ಬೀರಬಲ್ ಸುಂದರ ಸರೋವರದ ದಡದಲ್ಲಿ ನಡೆದಾಡುತ್ತಿದ್ದರು. ನೀರು ಮಂಜಿನಂತೆ ತಣ್ಣಗಿತ್ತು.",
                "Adu chaligaalada teevra samjeyaagittu. Baadashaaha Akbar mattu Beerabal sundara sarovarada dadadalli nadedaaduttiddaru. Neeru manjinaante tannagittu.",
                "On a freezing winter evening, Emperor Akbar and his witty advisor Birbal strolled along the tranquil lake shore. The water was icy cold."
            ),
            StoryParagraph(
                2,
                "अकबर ने कहा, 'क्या कोई इंसान रात भर इस बर्फीले पानी में खड़ा रह सकता है?' एक गरीब धोबी ने अपने परिवार की भूख मिटाने के लिए यह चुनौती स्वीकार की।",
                "Akbar ne kaha, 'Kya koi insaan raat bhar is barfeele paani me khada rah sakta hai?' Ek gareeb dhobi ne apne parivaar ki bhookh mitaane ke liye yeh chunauti sweekaar ki.",
                "ಅಕ್ಬರನು, 'ಯಾರಾದರೂ ಇಡೀ ರಾತ್ರಿ ಈ ತಣ್ಣೀರಿನಲ್ಲಿ ನಿಲ್ಲಲು ಸಾಧ್ಯವೇ?' ಎಂದು ಕೇಳಿದನು. ಬಡ ಅಗಸನೊಬ್ಬ ತನ್ನ ಕುಟುಂಬದ ಬಡತನ ನೀಗಿಸಲು ಈ ಸವಾಲನ್ನು ಒಪ್ಪಿಕೊಂಡನು.",
                "Akbaranu, 'Yaaraadaru idee raatri ee tanneerinalli nillalu saadhyave?' endu kelidanu. Bada agasanobba tanna kutumbada badatana neegisalu ee savaalannu oppikondanu.",
                "Akbar wondered if anyone could endure standing in the icy lake all night. A poor washerman agreed to take the challenge to feed his hungry family."
            ),
            StoryParagraph(
                3,
                "धोबी रात भर काँपते हुए पानी में खड़ा रहा। उसने दूर महल में जलते हुए एक छोटे से दीपक को देखा और उसी की लौ पर ध्यान केंद्रित करके रात बिताई।",
                "Dhobi raat bhar kaanpte hue paani me khada raha. Usne door mahal me jalte hue ek chhote se deepak ko dekha aur usi ki lau par dhyaan kendrit karke raat bitaai.",
                "ಅಗಸನು ರಾತ್ರಿಯಿಡೀ ನಡುಗುತ್ತಾ ನೀರಿನಲ್ಲಿ ನಿಂತನು. ಅರಮನೆಯ ಎತ್ತರದ ಉಪ್ಪರಿಗೆಯಲ್ಲಿ ಉರಿಯುತ್ತಿದ್ದ ಪುಟ್ಟ ದೀಪದ ಬೆಳಕನ್ನು ನೋಡುತ್ತಾ ಮನಸ್ಸನ್ನು ಗಟ್ಟಿಮಾಡಿ ರಾತ್ರಿ ಕಳೆದನು.",
                "Agasanu raatriyidee naduguttaa neerinalli nintanu. Aramaneya ettarada upparigeyalli uriyuttidda putta deepada belakannu noduttaa manassannu gattimaadi raatri kaledanu.",
                "The washerman stood in the biting water all night, keeping his gaze fixed on a distant lamp glowing atop the imperial palace to maintain his courage."
            ),
            StoryParagraph(
                4,
                "सुबह जब वह इनाम लेने दरबार पहुँचा, तो अकबर ने कहा, 'तुमने महल के दीये की गर्मी से खुद को बचाया, इसलिए तुम्हें कोई इनाम नहीं मिलेगा!' धोबी उदास होकर लौट गया।",
                "Subah jab wah inaam lene darbaar pahuncha, to Akbar ne kaha, 'Tumne mahal ke deeye ki garmi se khud ko bachaaya, isliye tumhe koi inaam nahi milega!' Dhobi udaas hokar laut gaya.",
                "ಬೆಳಿಗ್ಗೆ ಆತ ಬಹುಮಾನ ಪಡೆಯಲು ದರ್ಬಾರಿಗೆ ಬಂದಾಗ, ಅಕ್ಬರನು 'ನೀನು ಅರಮನೆಯ ದೀಪದ ಶಾಖದಿಂದ ಬೆಚ್ಚಗಾಗಿದ್ದೀಯ, ನಿನಗೆ ಬಹುಮಾನವಿಲ್ಲ!' ಎಂದನು. ಅಗಸ ಕಣ್ಣೀರಿಡುತ್ತಾ ಮರಳಿದನು.",
                "Beligge aatha bahumaana padeyalu darbaarige bandaaga, Akbaranu 'Neenu aramaneya deepada shaakhadinda bechchagaagiddeeya, ninage bahumaanavilla!' endanu. Agasa kanneeriduttaa maralidanu.",
                "Next morning, Akbar declared that the distant lamp had provided warmth to the washerman, and unfairly denied him his prize. The heartbroken man wept."
            ),
            StoryParagraph(
                5,
                "अगले दिन बीरबल दरबार नहीं आए। अकबर उन्हें देखने उनके घर पहुँचे। उन्होंने देखा कि ज़मीन पर आग जल रही थी और खिचड़ी की हाँडी पेड़ की बहुत ऊँची डाल पर लटकी थी!",
                "Agle din Birbal darbaar nahi aaye. Akbar unhe dekhne unke ghar pahunche. Unhone dekha ki zameen par aag jal rahi thi aur khichdi ki haandi ped ki bahut oonchi daal par latki thi!",
                "ಮಾರನೆಯ ದಿನ ಬೀರಬಲ್ಲನು ದರ್ಬಾರಿಗೆ ಬರಲಿಲ್ಲ. ಅಕ್ಬರನು ಆತನ ಮನೆಗೆ ಹೋದಾಗ, ನೆಲದ ಮೇಲೆ ಬೆಂಕಿ ಉರಿಯುತ್ತಿತ್ತು, ಆದರೆ ಖಿಚಡಿಯ ಮಡಕೆಯು ಮರದ ತುತ್ತತುದಿಯ ಕೊಂಬೆಗೆ ನೇತಾಡುತ್ತಿತ್ತು!",
                "Maaraneya dina Beeraballanu darbaarige baralilla. Akbaranu aatana manege hodaaga, nelada mele benki uriyuttittu, aadare khichadiya madakeyu marada tuttutudiya kombege netaaduttittu!",
                "The next day, Birbal did not come to court. Akbar visited him and found a small fire burning on the grass, while the cooking pot was tied high up in a tall tree branch!"
            ),
            StoryParagraph(
                6,
                "अकबर हँसकर बोले, 'बीरबल, इतनी दूर आग से खिचड़ी कैसे पकेगी?' बीरबल ने मुस्कुराकर कहा, 'जहाँपनाह, अगर महल का दूर का दीया धोबी को गर्मी दे सकता है, तो यह आग भी खिचड़ी पका सकती है!'",
                "Akbar hanskar bole, 'Birbal, itni door aag se khichdi kaise pakegi?' Birbal ne muskuraakar kaha, 'Jahaanpanaah, agar mahal ka door ka deeya dhobi ko garmi de sakta hai, to yeh aag bhi khichdi paka sakti hai!'",
                "ಅಕ್ಬರನು ನಕ್ಕು, 'ಬೀರಬಲ್, ಇಷ್ಟು ದೂರದಿಂದ ಬೆಂಕಿ ಮಡಕೆಯನ್ನು ಹೇಗೆ ಬೇಯಿಸಲು ಸಾಧ್ಯ?' ಎಂದನು. ಬೀರಬಲ್ಲನು, 'ಪ್ರಭು, ಅರಮನೆಯ ದೀಪ ಅಗಸನಿಗೆ ಶಾಖ ಕೊಟ್ಟರೆ, ಈ ಬೆಂಕಿ ಖಿಚಡಿಯನ್ನು ಬೇಯಿಸಬಲ್ಲದು!' ಎಂದನು.",
                "Akbaranu nakku, 'Beerabal, ishtu dooradinda benki madakeyannu hege beyisalu saadhya?' endanu. Beeraballanu, 'Prabhu, aramaneya deepa agasanige shaakha kottare, ee benki khichadiyannu beyisaballadu!' endanu.",
                "Akbar chuckled, 'Birbal, how can the heat reach a pot hung so high?' Birbal smiled gently, 'Sire, if a tiny distant lamp can warm a man in an icy lake, why not my pot?'"
            ),
            StoryParagraph(
                7,
                "बादशाह अकबर अपनी गलती समझ गए। उन्होंने बीरबल की बुद्धिमानी की दाद दी और धोबी को बुलाकर सोने के सिक्कों का बड़ा उपहार और सम्मान दिया।",
                "Baadshah Akbar apni galti samajh gaye. Unhone Birbal ki buddhimaani ki daad di aur dhobi ko bulaakar sone ke sikkon ka bada upahaar aur sammaan diya.",
                "ಬಾದಶಾಹ ಅಕ್ಬರನಿಗೆ ತನ್ನ ತಪ್ಪಿನ ಅರಿವಾಯಿತು. ಆತ ಬೀರಬಲ್ಲನ ಚಾತುರ್ಯವನ್ನು ಪ್ರಶಂಸಿಸಿ, ಬಡ ಅಗಸನನ್ನು ಕರೆಸಿ ಚಿನ್ನದ ನಾಣ್ಯಗಳ ದೊಡ್ಡ ಬಹುಮಾನವನ್ನು ನೀಡಿ ಗೌರವಿಸಿದನು.",
                "Baadashaaha Akbaranige tanna tappina arivaayitu. Aatha Beeraballana chaaturyavannu prashamsisi, bada agasanannu karesi chinnada naanyagala dodda bahumaanavannu needi gauravisidanu.",
                "Realizing his unfair mistake, Emperor Akbar praised Birbal's wisdom, summoned the humble washerman, and rewarded him handsomely with a bag of gold coins."
            )
        ),

        46 to listOf(
            StoryParagraph(
                1,
                "एक बार विजयनगर में चोरों का एक गिरोह सक्रिय हो गया था। वे रात में बड़े-बड़े घरों में चोरी करते थे। राजा कृष्णदेवराय इस बात से बहुत चिंतित थे।",
                "Ek baar Vijayanagar me choron ka ek giroh sakriya ho gaya tha. We raat me bade-bade gharon me chori karte the. Raja Krishnadevaraya is baat se bahut chintit the.",
                "ಒಮ್ಮೆ ವಿಜಯನಗರದಲ್ಲಿ ಕಳ್ಳರ ಗುಂಪೊಂದು ಬಹಳ ಉಪಟಳ ನೀಡುತ್ತಿತ್ತು. ಅವರು ರಾತ್ರಿ ವೇಳೆಯಲ್ಲಿ ಶ್ರೀಮಂತರ ಮನೆಗಳಲ್ಲಿ ಕನ್ನ ಹಾಕುತ್ತಿದ್ದರು. ರಾಜ ಕೃಷ್ಣದೇವರಾಯರಿಗೆ ಇದು ಚಿಂತೆಯಾಗಿತ್ತು.",
                "Omme Vijayanagaradalli kallara gumpondu bahala upatala needuttittu. Avaru raatri veleyalli sreemantara manegalalli kanna haakuttiddaru. Raaja Krishnadevaraayarige idu chinteyaagittu.",
                "In the vibrant empire of Vijayanagar, a gang of clever thieves had been prowling at night. King Krishnadevaraya was deeply worried about his citizens."
            ),
            StoryParagraph(
                2,
                "एक शाम तेनाली राम ने अपने बगीचे की झाड़ियों में दो अजनबियों को छिपते देखा। तेनाली समझ गए कि वे चोर हैं और रात में उनके घर में घुसने की योजना बना रहे हैं।",
                "Ek shaam Tenali Ram ne apne bageeche ki jhaadiyon me do ajnabiyon ko chhipte dekha. Tenali samajh gaye ki we chor hain aur raat me unke ghar me ghusne ki yojana bana rahe hain.",
                "ಒಂದು ಸಂಜೆ ತೆನಾಲಿ ರಾಮನು ತನ್ನ ತೋಟದ ಪೊದೆಯಲ್ಲಿ ಇಬ್ಬರು ಅಪರಿಚಿತರು ಅವಿತುಕೊಂಡಿರುವುದನ್ನು ಗಮನಿಸಿದನು. ಅವರು ರಾತ್ರಿ ಕಳ್ಳತನಕ್ಕೆ ಬಂದಿರುವ ಕಳ್ಳರೆಂದು ಆತನಿಗೆ ತಿಳಿಯಿತು.",
                "Ondu samje Tenali Ramanu tanna totada podeyalli ibbaru aparichitaru avitukondiruvudannu gamanisidanu. Avaru raatri kallatanakke bandiruva kallarendu aatanige tiliyitu.",
                "One evening, Tenali Rama noticed two suspicious men hiding behind his mango trees. He realized at once that they were thieves waiting for darkness."
            ),
            StoryParagraph(
                3,
                "तेनाली राम घर के अंदर गए और ज़ोर से अपनी पत्नी से बोले, 'सुनो! शहर में चोर घूम रहे हैं। हम अपने सोने-चाँदी के सारे गहने लोहे के बड़े संदूक में भरकर कुएँ में छिपा देते हैं!'",
                "Tenali Ram ghar ke andar gaye aur zor se apni patni se bole, 'Suno! Shahar me chor ghoom rahe hain. Hum apne sone-chaandi ke saare gehne lohe ke bade sandook me bharkar kuen me chhipa dete hain!'",
                "ತೆನಾಲಿ ರಾಮನು ಮನೆಯೊಳಗೆ ಹೋಗಿ ಜೋರಾಗಿ ಪತ್ನಿಗೆ, 'ಕೇಳಿದೆಯಾ! ನಗರದಲ್ಲಿ ಕಳ್ಳರಿದ್ದಾರೆ. ನಮ್ಮ ಎಲ್ಲಾ ಚಿನ್ನದ ಆಭರಣಗಳನ್ನು ದೊಡ್ಡ ಪೆಟ್ಟಿಗೆಯಲ್ಲಿ ಹಾಕಿ ಹಿತ್ತಲ ಬಾವಿಯಲ್ಲಿ ಅಡಗಿಸಿಡೋಣ!' ಎಂದು ಕೂಗಿದನು.",
                "Tenali Ramanu maneyolage hogi joraagi patnige, 'Kelideyaa! Nagaradalli kallariddaare. Namma ellaa chinnada aabharanaagalannu dodda pettigeyalli haaki hittala baaviyalli adagisidona!' endu koogidanu.",
                "Tenali Rama casually walked inside and called out loudly to his wife, 'Dearest! With thieves on the loose, let us pack all our gold and jewels into our iron trunk and drop it into the garden well!'"
            ),
            StoryParagraph(
                4,
                "झाड़ियों में छिपे चोरों ने यह सुना और मन ही मन हँसे। तेनाली और उनकी पत्नी ने भारी पत्थर संदूक में भरे और दोनों ने मिलकर उसे 'धड़ाम' से कुएँ में फेंक दिया!",
                "Jhaadiyon me chhipe choron ne yeh suna aur man hi man hanse. Tenali aur unki patni ne bhaari patthar sandook me bhare aur dono ne milkar use 'dhadhaam' se kuen me phenk diya!",
                "ಪೊದೆಯಲ್ಲಿದ್ದ ಕಳ್ಳರು ಇದನ್ನು ಕೇಳಿ ಸಂಭ್ರಮಿಸಿದರು. ತೆನಾಲಿ ರಾಮ ಹಾಗೂ ಪತ್ನಿ ಭಾರವಾದ ಕಲ್ಲುಗಳನ್ನು ಪೆಟ್ಟಿಗೆಯಲ್ಲಿ ತುಂಬಿ 'ದೊಪ್ಪನೆ' ಬಾವಿಗೆ ಎಸೆದರು!",
                "Podeyallidda kallaru idannu keli sambhramisidaru. Tenali Rama haagoo patni bhaaravaada kallugalannu pettigeyalli tumbi 'doppane' baavige esedaru!",
                "Overhearing this, the thieves rejoiced in secret. Tenali Rama and his wife filled an old sturdy trunk with heavy garden stones and dropped it with a loud splash into the well!"
            ),
            StoryParagraph(
                5,
                "रात गहरी होने पर चोर कुएँ के पास आए। संदूक निकालने के लिए उन्होंने कुएँ से पानी निकालना शुरू किया। वे बाल्टी भर-भरकर पानी निकालते रहे।",
                "Raat gehri hone par chor kuen ke paas aaye. Sandook nikaalne ke liye unhone kuen se paani nikaalna shuru kiya. We baalti bhar-bharkar paani nikaalte rahe.",
                "ರಾತ್ರಿ ಕತ್ತಲಾದಾಗ ಕಳ್ಳರು ಬಾವಿಯ ಬಳಿ ಬಂದರು. ಪೆಟ್ಟಿಗೆಯನ್ನು ಹೊರತೆಗೆಯಲು ಬಾವಿಯ ನೀರನ್ನು ಸೇದತೊಡಗಿದರು. ಬಿಂದಿಗೆಗಳಲ್ಲಿ ನೀರು ಸೇದಿ ತೋಟಕ್ಕೆ ಚೆಲ್ಲಿದರು.",
                "Raatri kattalaadaaga kallaru baaviya bali bandaru. Pettigeyannu horategeyalu baaviya neerannu sedatodagidaru. Bindigegalalli neeru sedi totakke chellidaru.",
                "At midnight, the thieves crept up to the well. In order to reach the sunken chest, they began drawing buckets of water and pouring it across the dry soil."
            ),
            StoryParagraph(
                6,
                "तेनाली राम ने चुपचाप पानी के रास्ते को अपने सूखे खेतों और पौधों की क्यारियों की ओर मोड़ दिया। पूरी रात चोर पानी खींचते रहे और तेनाली का पूरा बगीचा मुफ्त में सींच गया!",
                "Tenali Ram ne chupchaap paani ke raaste ko apne sookhe kheton aur paudhon ki kyaariyon ki or mod diya. Poori raat chor paani kheenchte rahe aur Tenali ka poora bageecha muft me seench gaya!",
                "ತೆನಾಲಿ ರಾಮನು ನೀರು ಹರಿಯುವ ಕಾಲುವೆಯನ್ನು ತನ್ನ ಒಣಗಿದ್ದ ಹೂತೋಟ ಮತ್ತು ತರಕಾರಿ ಗದ್ದೆಗಳ ಕಡೆ ತಿರುಗಿಸಿದನು! ಕಳ್ಳರು ಬೆಳಗಿನ ಜಾವದವರೆಗೂ ಕಷ್ಟಪಟ್ಟು ಇಡೀ ತೋಟಕ್ಕೆ ನೀರುಣಿಸಿದರು!",
                "Tenali Ramanu neeru hariyuva kaaluveyannu tanna onagidda hootota mattu tarakaari gaddegala kade tirugisidanu! Kallaru belagina jaavadavaregoo kashtapattu idee totakke neerunisidaru!",
                "Clever Tenali quietly redirected the outflow channels straight into his parched vegetable beds. All night long, the thieves toiled, irrigating Tenali's entire garden for free!"
            ),
            StoryParagraph(
                7,
                "सुबह होते ही तेनाली हाथ जोड़कर बोले, 'धन्यवाद भाइयों! मेरे पूरे बगीचे को पानी देने के लिए बहुत शुक्रिया।' घबराकर चोर भागे और सैनिकों ने उन्हें पकड़ लिया।",
                "Subah hote hi Tenali haath jodkar bole, 'Dhanyavaad bhaiyon! Mere poore bageeche ko paani dene ke liye bahut shukriya.' Ghabraakar chor bhaage aur sainikon ne unhe pakad liya.",
                "ಬೆಳಗಾಗುತ್ತಲೇ ತೆನಾಲಿ ಕೈಮುಗಿದು, 'ಸ್ನೇಹಿತರೇ, ನನ್ನ ಒಣಗಿದ ತೋಟಕ್ಕೆ ನೀರುಣಿಸಿದ್ದಕ್ಕೆ ಧನ್ಯವಾದ!' ಎಂದನು. ಕಳ್ಳರು ಗಾಬರಿಯಾಗಿ ಓಡಿದರು, ಅಷ್ಟರಲ್ಲಿ ಕಾವಲುಗಾರರು ಅವರನ್ನು ಸೆರೆಹಿಡಿದರು.",
                "Belagaaguttale Tenali kaimugidu, 'Snehitare, nanna onagida totakke neerunisiddakke dhanyavaada!' endanu. Kallaru gaabariyaagi odidaru, ashtaralli kaavalugaararu avarannu serehididaru.",
                "At dawn, Tenali Rama appeared and bowed politely, 'Thank you, kind gentlemen, for watering my entire orchard!' The exhausted thieves fled in panic right into the royal guards' hands."
            )
        )
    )

    // Build the complete 300 stories collection
    val allStories: List<Story> by lazy {
        val list = mutableListOf<Story>()

        for (i in 1..300) {
            val titleItem = StoryCatalogueData.getTitleItem(i)
            val cat = titleItem.category
            val grade = ((i - 1) % 4) + 1
            val duration = 8 + (i % 3) // 8 to 10 mins reading mode
            val emoji = titleItem.emoji

            val hScript = titleItem.hindi
            val hTranslit = titleItem.hindiTranslit
            val kScript = titleItem.kannada
            val kTranslit = titleItem.kannadaTranslit
            val mScript = titleItem.malayalam
            val mTranslit = titleItem.malayalamTranslit

            // Use curated paragraphs if available, else generated structured narrative
            val paras = detailedStorySamples[i] ?: generateTrilingualNarrative(
                titleItem.english,
                hScript,
                hTranslit,
                kScript,
                kTranslit,
                mScript,
                mTranslit,
                cat
            )

            val moral = generateMoralForCategory(cat, titleItem.english)

            list.add(
                Story(
                    id = "story_$i",
                    number = i,
                    titleEnglish = titleItem.english,
                    titleHindi = hScript,
                    titleHindiTranslit = hTranslit,
                    titleKannada = kScript,
                    titleKannadaTranslit = kTranslit,
                    titleMalayalam = mScript,
                    titleMalayalamTranslit = mTranslit,
                    category = cat,
                    cbseClass = grade,
                    durationMinutes = duration,
                    coverEmoji = emoji,
                    summary = titleItem.themeSummary,
                    paragraphs = paras,
                    moral = moral,
                    characters = listOf("Narrator", "Seeker", "Mentor")
                )
            )
        }
        list
    }

    private fun generateTrilingualNarrative(
        titleEng: String,
        titleHi: String,
        translitHi: String,
        titleKn: String,
        translitKn: String,
        titleMl: String,
        translitMl: String,
        category: String
    ): List<StoryParagraph> {
        return when (category) {
            "Motivational & Keep Going" -> listOf(
                StoryParagraph(
                    1,
                    "एक छोटे से गाँव में एक नन्हा बालक रहता था जिसका सपना आकाश छूने का था। लोग कहते थे कि यह असंभव है।",
                    "Ek chhote se gaanw me ek nanha baalak rehta tha jiska sapna aakaash chhoone ka tha. Log kehte the ki yeh asambhav hai.",
                    "ಒಂದು ಪುಟ್ಟ ಹಳ್ಳಿಯಲ್ಲಿ ಆಕಾಶವನ್ನು ಮುಟ್ಟುವ ಕನಸು ಹೊತ್ತ ಬಾಲಕನೊಬ್ಬನಿದ್ದ. ಜನರು ಇದು ಅಸಾಧ್ಯವೆನ್ನುತ್ತಿದ್ದರು.",
                    "Ondu putta halliyalli aakaashavannu muttuva kanasu hotta baalakanobbanidda. Janaru idu asaadhyavennuttiddaru.",
                    "In a small village lived a young soul who dreamed of touching the sky. Many whispered that it was impossible.",
                    "ഒരു കൊച്ചു ഗ്രാമത്തിൽ ആകാശത്തെ തൊടാൻ സ്വപ്നം കണ്ട ഒരു ബാലൻ ജീവിച്ചിരുന്നു. അത് അസാധ്യമാണെന്ന് ആളുകൾ പറഞ്ഞു.",
                    "Oru kochu graamathil aakaashaththe thodaan swapnam kanda oru baalan jeevichirunnu. Athu asaadhyamaanennu aalukal paranju."
                ),
                StoryParagraph(
                    2,
                    "रास्ते में कई बाधाएं आईं और वह कई बार फिसला। उसके घुटनों पर चोटें लगीं और निराशा ने उसे घेरा।",
                    "Raaste me kayi baadhaayein aayin aur woh kayi baar phisla. Uske ghutnon par chotein lageen aur niraasha ne usey ghera.",
                    "ದಾರಿಯಲ್ಲಿ ಹಲವು ಅಡ್ಡಿಗಳು ಬಂದವು, ಅವನು ಹಲವು ಬಾರಿ ಎಡವಿ ಬಿದ್ದನು. ಮೊಣಕಾಲಿಗೆ ಗಾಯಗಳಾದರೂ ಅವನ ಆಸೆ ಬತ್ತಲಿಲ್ಲ.",
                    "Daariyalli halavu addigalu bandavu, avanu halavu baari edavi biddanu. Monakaalige gaayagalaadaroo avana aase battalilla.",
                    "Many obstacles blocked the way and he stumbled repeatedly. Though bruised and tired, his spirit never wavered.",
                    "വഴിയിൽ പല തടസ്സങ്ങളും ഉണ്ടായി, അവൻ പലതവണ വീണുപോയി. മുറിവുകൾ ഏറ്റിട്ടും അവൻ പിന്മാറിയില്ല.",
                    "Vazhiyil pala thadassangalum undaayi, avan palathavana veenupoyi. Murivukal ettittum avan pinmaariyilla."
                ),
                StoryParagraph(
                    3,
                    "तभी एक वृद्ध गुरुजी ने कहा, 'पीछे मत हटो! जो गिरकर फिर खड़ा होता है, वही मंज़िल पाता है।' बालक ने गहरी साँस ली और उठ खड़ा हुआ।",
                    "Tabhi ek vriddha guruji ne kaha, 'Peechhe mat hato! Jo girkar phir khada hota hai, wahi manzil paata hai.' Baalak ne gehri saans li aur uth khada hua.",
                    "ಆಗ ಹಿರಿಯ ಗುರುಗಳು, 'ಹಿಂದೆ ಸರಿಯಬೇಡ! ಬಿದ್ದು ಮರಳಿ ಏಳುವವನೇ ಗುರಿ ತಲುಪಬಲ್ಲ' ಎಂದರು. ಬಾಲಕನು ದೃಢಸಂಕಲ್ಪದಿಂದ ಎದ್ದು ನಿಂತನು.",
                    "Aaga hiriya gurugalu, 'Hinde sariyabeda! Biddu marali eluvavane guri talupaballa' endaru. Baalakanu drudhasankalpadinda eddu nintanu.",
                    "Then a wise elder said, 'Do not look back or stop! Whoever rises after falling conquers every peak.' Taking courage, he stood up anew.",
                    "അപ്പോൾ ഒരു വൃദ്ധ ഗുരു പറഞ്ഞു, 'പിന്നോട്ട് പോകരുത്! വീണിട്ട് വീണ്ടും എഴുന്നേൽക്കുന്നവനാണ് ലക്ഷ്യത്തിലെത്തുന്നത്.' അവൻ വീണ്ടും എഴുന്നേറ്റു.",
                    "Appol oru vriddha guru paranju, 'Pinnoatu pokaruthu! Veenittu veendum ezhunnelkkunnavanaanu lakshyathiletthunnathu.' Avan veendum ezhunnettu."
                ),
                StoryParagraph(
                    4,
                    "उसने हर असफलता को एक नया सबक माना और बिना रुके कदम बढ़ाता रहा। उसका हौसला देख बादल भी राह देने लगे।",
                    "Usne har asaphalta ko ek naya sabak maana aur bina ruke kadam badhaata raha. Uska hausla dekh baadal bhi raah dene lage.",
                    "ಅವನು ಪ್ರತಿಯೊಂದು ಸೋಲನ್ನೂ ಹೊಸ ಪಾಠವೆಂದು ಪರಿಗಣಿಸಿ ಮುನ್ನುಗ್ಗಿದನು. ಅವನ ಅಚಲ ಉತ್ಸಾಹ ನೋಡಿ ಹಾದಿ ಸುಗಮವಾಯಿತು.",
                    "Avanu pratiyondu solannoo hosa paathavendu pariganisi munnuggidanu. Avana achala utsaaha nodi haadi sugamavaayitu.",
                    "He treated every stumble as a lesson and took steady strides forward without pausing. Dedication cleared every fog ahead.",
                    "അവൻ ഓരോ പരാജയത്തെയും പാഠമാക്കി മാറ്റുകയും തളരാതെ മുന്നോട്ട് നടക്കുകയും ചെയ്തു. അവന്റെ നിശ്ചയദാർഢ്യം വിജയം കൊണ്ടുവന്നു.",
                    "Avan oaro paraajayatheeyum paadamaakki maattukayum thalaraathe munnoatu nadakkukayum cheythu. Avante nischayadaardhyam vijayam konduvannu."
                ),
                StoryParagraph(
                    5,
                    "अंत में वह सबसे ऊँचे शिखर पर पहुँच गया। उसने मुस्कुराकर सीखा कि जब तक हम चलते रहते हैं, कोई भी शक्ति हमें रोक नहीं सकती।",
                    "Ant me woh sabse oonche shikhar par pahunch gaya. Usne muskuraakar seekha ki jab tak hum chalte rehte hain, koi bhi shakti humein rok nahi sakti.",
                    "ಅಂತಿಮವಾಗಿ ಅವನು ಪರ್ವತದ ಎತ್ತರದ ಶಿಖರ ತಲುಪಿದನು. ಸತತವಾಗಿ ಮುನ್ನಡೆಯುವವನನ್ನು ಯಾರೂ ತಡೆಯಲಾರರು ಎಂದು ಅವನು ಅರಿತುಕೊಂಡನು.",
                    "Antimavaagi avanu parvatada ettarada shikhara talupidanu. Satatavaagi munnadeyuvavanannu yaaroo tadeyalaararu endu avanu aritukondanu.",
                    "At last, he reached the highest mountain summit. With a radiant smile, he understood that persistent steps will always conquer the journey.",
                    "ഒടുവിൽ അവൻ ആ കൊടുമുടിയുടെ നെറുകയിലെത്തി. മുന്നേറിക്കൊണ്ടിരിക്കുന്നവനെ ഒന്നിനും തടയാനാവില്ലെന്ന് അവൻ മനസ്സിലാക്കി.",
                    "Oduvil avan aa kodumudiyude nerukayiletthi. Munnerikkondirikkunnavane onninum thadayaanaavillennu avan manassilaakki."
                )
            )

            "Gratitude & Thankfulness" -> listOf(
                StoryParagraph(
                    1,
                    "एक छोटे खेत में एक मेहनती किसान रोज़ सुबह सूरज और धरती को नमन करके अपना दिन शुरू करता था।",
                    "Ek chhote khet me ek mehnati kisaan roz subah sooraj aur dharti ko naman karke apna din shuru karta tha.",
                    "ಒಂದು ಪುಟ್ಟ ಹೊಲದಲ್ಲಿ ಪರಿಶ್ರಮಿ ರೈತನೊಬ್ಬನು ಮುಂಜಾನೆ ಸೂರ್ಯ ಮತ್ತು ಭೂತಾಯಿಗೆ ವಂದಿಸಿ ತನ್ನ ದಿನಚರಿ ಆರಂಭಿಸುತ್ತಿದ್ದನು.",
                    "Ondu putta holadalli parishrami raitanobbanu munjaane soorya mattu bhootaayige vandisi tanna dinachari aarambhisuttiddanu.",
                    "In a peaceful farm, a diligent farmer began every sunrise with a bow of deep gratitude to the earth, rain, and sun.",
                    "ഒരു കൊച്ചു കൃഷിയിടത്തിൽ ഒരു കർഷകൻ ദിവസവും പ്രഭാതത്തിൽ സൂര്യനെയും ഭൂമിയെയും തൊഴുത് തന്റെ ജോലി തുടങ്ങിയിരുന്നു.",
                    "Oru kochu krishiyidathil oru karshakan dhivasavum prabhaathathil sooryaneyum bhoomiyeyum thozhuthu thante joli thudangiyirunnu."
                ),
                StoryParagraph(
                    2,
                    "उसके पास बहुत अधिक धन नहीं था, लेकिन जो भी था, वह उसके लिए ईश्वर और प्रकृति का कोटि-कोटि धन्यवाद करता था।",
                    "Uske paas bahut adhik dhan nahi tha, lekin jo bhi tha, woh uske liye ishwar aur prakriti ka koti-koti dhanyavaad karta tha.",
                    "ಅವನ ಬಳಿ ಅಪಾರ ಆಸ್ತಿಯಿರಲಿಲ್ಲ, ಆದರೂ ಇದ್ದಷ್ಟರಲ್ಲೇ ಅವನು ಪ್ರಕೃತಿ ಮತ್ತು ದೇವರಿಗೆ ಸದಾ ಕೃತಜ್ಞನಾಗಿದ್ದನು.",
                    "Avana bali apaara aastiyiralilla, aadaroo iddashtarelle avanu prakriti mattu devarige sadaa kritajnanaagiddanu.",
                    "He possessed no grand fortune, yet his soul overflowed with thankfulness for fresh water, warm bread, and loving company.",
                    "അവന് വലിയ സമ്പത്തുണ്ടായിരുന്നില്ല, എങ്കിലും ഉള്ളതിൽ അവൻ സന്തുഷ്ടനും പ്രകൃതിയോട് എപ്പോഴും നന്ദിയുള്ളവനുമായിരുന്നു.",
                    "Avanu valiya sambaththeyundaayirunnilla, engilum ullathil avan santhushtanum prakrithiyodu eppozhum nandiyullavanumaayirunnu."
                ),
                StoryParagraph(
                    3,
                    "गाँव का एक धनी व्यापारी हमेशा अधिक पाने की लालसा में दुखी और बेचैन रहता था। उसने किसान से उसकी मुस्कान का रहस्य पूछा।",
                    "Gaanw ka ek dhani vyaapaari hamesha adhik paane ki laalsa me dukhi aur bechain rehta tha. Usne kisaan se uski muskaan ka rahasya poochha.",
                    "ಊರಿನ ಶ್ರೀಮಂತ ವ್ಯಾಪಾರಿಯೊಬ್ಬನು ಇನ್ನೂ ಹೆಚ್ಚು ಸಂಪತ್ತಿನ ಆಸೆಯಿಂದ ಯಾವಾಗಲೂ ಅಸಮಾಧಾನದಿಂದ ಇದ್ದನು. ಅವನು ರೈತನನ್ನು ಸಂತೋಷದ ರಹಸ್ಯ ಕೇಳಿದನು.",
                    "Oorina shreemanta vyaapaariyobbanu innoo hecchu sampattina aaseyinda yaavaagaloo asamaadhaanadinda iddanu. Avanu raitanannu santosshada rahasya kelidanu.",
                    "A wealthy merchant nearby constantly complained about what he lacked. Astonished by the farmer's joy, he asked the secret of his peace.",
                    "നാട്ടിലെ ധനികനായ വ്യാപാരി എപ്പോഴും കൂടുതൽ സമ്പത്ത് വേണമെന്ന് ആഗ്രഹിച്ച് അസ്വസ്ഥനായിരുന്നു. അവൻ കർഷകനോട് സന്തോഷത്തിന്റെ രഹസ്യം ചോദിച്ചു.",
                    "Naattile dhanikanaaya vyaapaari eppozhum kooduthal sambathu venamennu aagrahichu aswasthanaayirunnu. Avan karshakanodu santhoshathinte rahasyam chodichu."
                ),
                StoryParagraph(
                    4,
                    "किसान ने कहा, 'धन्यवाद का भाव ही सबसे बड़ा खजाना है। जब हम मिली हुई खुशियों की गिनती करते हैं, तो दुख अपने आप विदा हो जाता है।' ",
                    "Kisaan ne kaha, 'Dhanyavaad ka bhaav hi sabse bada khazaana hai. Jab hum mili hui khushiyon ki ginti karte hain, to dukh apne aap vida ho jaata hai.'",
                    "ರೈತನು ನಗುತ್ತಾ, 'ಕೃತಜ್ಞತೆಯೇ ಜಗತ್ತಿನ ಮಹಾನ್ ನಿಧಿ. ನಮ್ಮಲ್ಲಿರುವ ಶುಭ ಸಂಗತಿಗಳಿಗೆ ಧನ್ಯವಾದ ಸಲ್ಲಿಸಿದರೆ ದುಃಖ ಕರಗುತ್ತದೆ' ಎಂದನು.",
                    "Raitanu naguttaa, 'Kritajnateye jagattina mahaan nidhi. Nammalliruva shubha sangatigalige dhanyavaada sallisidare duhkha karaguttade' endanu.",
                    "The farmer replied softly, 'Gratitude is life's true treasure. When you count blessings instead of grievances, joy blossoms naturally.'",
                    "കർഷകൻ പറഞ്ഞു, 'നന്ദിയുള്ള മനസ്സാണ് ഏറ്റവും വലിയ ധനം. ലഭിച്ച അനുഗ്രഹങ്ങളെ സ്മരിക്കുമ്പോൾ ദുഃഖം അകന്നുപോകുന്നു.'",
                    "Karshakan paranju, 'Nandiyulla manassaanu ettavum valiya dhanam. Labhicha anugrahangale smarikkumpol duhkham akannupokunnu.'"
                ),
                StoryParagraph(
                    5,
                    "व्यापारी ने अपनी आँखें खोलीं और पहली बार दूसरों की भलाई के लिए आभार व्यक्त करना सीखा। उसका घर सच्चा स्वर्ग बन गया।",
                    "Vyaapaari ne apni aankhein kholeen aur pehli baar doosron ki bhalaai ke liye aabhaar vyakt karna seekha. Uska ghar sachha swarg ban gaya.",
                    "ವ್ಯಾಪಾರಿಯು ತನ್ನ ತಪ್ಪನ್ನು ತಿದ್ದಿಕೊಂಡು, ಸಣ್ಣ ಸಣ್ಣ ಉಪಕಾರಗಳಿಗೂ ಧನ್ಯವಾದ ತಿಳಿಸಲು ಆರಂಭಿಸಿದನು. ಅವನ ಜೀವನ ಸುಖಮಯವಾಯಿತು.",
                    "Vyaapaariyu tanna tappannu tiddikondu, sanna sanna upakaaragaligoo dhanyavaada tilisalu aarambhisidanu. Avana jeevana sukhamayavaayitu.",
                    "The merchant opened his heart to thankfulness. In cherishing what he already had, his home was filled with genuine serenity and warmth.",
                    "വ്യാപാരി തന്റെ തെറ്റ് മനസ്സിലാക്കി എല്ലാവരോടും നന്ദിയോടെ പെരുമാറാൻ തുടങ്ങി. അവന്റെ ജീവിതം സമാധാനപൂർണ്ണമായി മാറി.",
                    "Vyaapaari thante thettu manassilaakki ellaavarodum nandiyode perumaaraan thudangi. Avante jeevitham samaadhaanapoornnamaayi maari."
                )
            )

            "Respect & Elders" -> listOf(
                StoryParagraph(
                    1,
                    "आश्रम में एक नटखट बालक आया था जो बहुत चंचल था और बड़ों की बातों को अनसुना कर देता था।",
                    "Aashram me ek natkhat baalak aaya tha jo bahut chanchal tha aur badon ki baaton ko ansuna kar deta tha.",
                    "ಆಶ್ರಮಕ್ಕೆ ಬಂದ ತುಂಟ ಬಾಲಕನೊಬ್ಬನು ಹಿರಿಯರ ಮಾತಿಗೆ ಹೆಚ್ಚು ಲಕ್ಷ್ಯ ಕೊಡುತ್ತಿರಲಿಲ್ಲ.",
                    "Aashramakke banda tunta baalakanobbanu hiriyara maatige hecchu lakshya koduttiralilla.",
                    "A spirited young student joined the hermitage academy, energetic but careless about listening to his elders.",
                    "ഗുരുകുലത്തിൽ എത്തിയ ഒരു കുട്ടി മുതിർന്നവരുടെ വാക്കുകളെ കാര്യമായി ഗൗനിച്ചിരുന്നില്ല.",
                    "Gurukulathil etthiya oru kutti muthirnavarude vaakkukale kaaryamaayi gounichirunnilla."
                ),
                StoryParagraph(
                    2,
                    "एक दिन वह जंगल में रास्ता भटक गया। काँटों और पत्थरों ने उसके पैर छलनी कर दिए और शाम घिर आई।",
                    "Ek din woh jungle me raasta bhatak gaya. Kaanton aur pattharon ne uske pair chhalni kar diye aur shaam ghir aayi.",
                    "ಒಂದು ದಿನ ಅವನು ದಟ್ಟ ಕಾಡಿನಲ್ಲಿ ಹಾದಿ ತಪ್ಪಿದನು. ಮುಳ್ಳುಗಳು ಚುಚ್ಚಿ ಕತ್ತಲಾಗುತ್ತಿದ್ದಂತೆ ಅವನು ಕಂಗಾಲಾದನು.",
                    "Ondu dina avanu datta kaadinalli haadi tappidanu. Mullugalu chucchi kattalaaguttiddante avanu kangaalaadanu.",
                    "One dusk, he lost his path deep in the thorny forest, regretting that he had disregarded the ancient forest master's warning.",
                    "ഒരു ദിവസം അവൻ കാട്ടിൽ വഴിതെറ്റിപ്പോയി. ഇരുട്ടു വീണപ്പോൾ അവൻ ഭയപ്പെട്ടു കരയാൻ തുടങ്ങി.",
                    "Oru dhivasam avan kaattil vazhithettippoyi. Iruttu veenappol avan bhayapettu karayaan thudangi."
                ),
                StoryParagraph(
                    3,
                    "तभी आश्रम के वृद्ध आचार्य लालटेन लेकर आए और उसे प्यार से गले लगाकर घर लाए।",
                    "Tabhi aashram ke vriddha aachaarya laalten lekar aaye aur usey pyaar se gale lagaakar ghar laaye.",
                    "ಆಗ ಆಶ್ರಮದ ಹಿರಿಯ ಆಚಾರ್ಯರು ದೀಪ ಹಿಡಿದು ಹುಡುಕಿಕೊಂಡು ಬಂದು, ಪ್ರೀತಿಯಿಂದ ಅಪ್ಪಿಕೊಂಡು ಕರೆದೊಯ್ದರು.",
                    "Aaga aashramada hiriya aachaaryaru deepa hididu hudukikondu bandu, preetiyinda appikondu karedoydaru.",
                    "Soon, the elder master arrived holding a gentle lantern, seeking him without anger, extending loving arms to shelter him.",
                    "അപ്പോൾ ആചാര്യൻ വിളക്കുമായി വന്ന് അവനെ സ്നേഹത്തോടെ മാറോടണച്ച് ആശ്രമത്തിലേക്ക് കൂട്ടിക്കൊണ്ടുപോയി.",
                    "Appol aachaaryan vilakkumaayi vannu avane snehathode maarodanachu aashramathilekku koottikkondupoyi."
                ),
                StoryParagraph(
                    4,
                    "बालक ने रोते हुए गुरुजी के चरण छुए और क्षमा माँगी। गुरुजी ने कहा, 'बड़ों का आदर कोई नियम नहीं, तुम्हारी सुरक्षा का कवच है।' ",
                    "Baalak ne rote hue guruji ke charan chhue aur kshama maangi. Guruji ne kaha, 'Badon ka aadar koi niyam nahi, tumhari suraksha ka kavach hai.'",
                    "ಬಾಲಕನು ಕಣ್ಣೀರಿಡುತ್ತಾ ಗುರುವಿನ ಪಾದಮುಟ್ಟಿ ಕ್ಷಮೆ ಕೋರಿದನು. 'ಹಿರಿಯರನ್ನು ಗೌರವಿಸುವುದು ನಿನ್ನ ರಕ್ಷಣೆಯ ಕವಚ' ಎಂದು ಗುರುಗಳು ಹರಸಿದರು.",
                    "Baalakanu kanneeriduttaa guruvina paadamutti kshame koridanu. 'Hiriyarannu gauravisuvudu ninna rakshaneya kavacha' endu gurugalu harasidaru.",
                    "Tears filling his eyes, the boy bowed humbly at the master's feet. 'Respecting parents and elders is not a restriction; it is your shield,' smiled the guru.",
                    "കുട്ടി കരഞ്ഞുകൊണ്ട് ആചാര്യന്റെ കാൽക്കൽ വീണ് മാപ്പപേക്ഷിച്ചു. 'മുതിർന്നവരെ ആദരിക്കുന്നത് നിങ്ങളുടെ സംരക്ഷണമാണ്' എന്ന് ഗുരു ഉപദേശിച്ചു.",
                    "Kutti karanjukondu aachaaryante kaalkkal veenu maappapekshichu. 'Muthirnavare aadarikkunnathu ningalude samrakshanamaanu' ennu guru upadeshichu."
                ),
                StoryParagraph(
                    5,
                    "उस दिन से उसने माता-पिता और गुरुजनों की हर बात का सम्मान किया और समाज में सबका प्रिय और आदर्श बन गया।",
                    "Us din se usne maata-pita aur gurujanon ki har baat ka sammaan kiya aur samaaj me sabka priya aur aadarsh ban gaya.",
                    "ಅಂದಿನಿಂದ ಅವನು ತಂದೆ-ತಾಯಿ ಮತ್ತು ಗುರುಗಳ ಮಾತಿಗೆ ತಲೆಬಾಗಿ ನಡೆದು ಸಮಾಜದಲ್ಲಿ ಆದರ್ಶ ವ್ಯಕ್ತಿಯಾದನು.",
                    "Andininda avanu tande-taayi mattu gurugala maatige talebaagi nadedu samaajadalli aadarsha vyaktiyaadanu.",
                    "From that evening onward, he honored his parents and teachers with devotion, becoming a beacon of grace and wisdom for all.",
                    "അന്നുമുതൽ അവൻ മാതാപിതാക്കളെയും ഗുരുക്കന്മാരെയും ബഹുമാനിക്കുകയും മാതൃകാപരമായ ജീവിതം നയിക്കുകയും ചെയ്തു.",
                    "Annumuthal avan maathaapithaakkaleyum gurukkanmaareyum bahumaanikkukayum maathrukaaparamaaya jeevitham nayikkukayum cheythu."
                )
            )

            "Grounded & Humility" -> listOf(
                StoryParagraph(
                    1,
                    "एक विशाल बागीचे में एक ऊँचा देवदार का पेड़ था जिसे अपनी ऊँचाई पर बड़ा घमंड था। वह हमेशा नीचे उगी नन्हीं दूब का मज़ाक उड़ाता।",
                    "Ek vishaal baageeche me ek ooncha devdaar ka ped tha jise apni oonchaai par bada ghamand tha. Woh hamesha neeche ugi nanhi doob ka mazaak udaata.",
                    "ಒಂದು ದೊಡ್ಡ ಉದ್ಯಾನದಲ್ಲಿ ಬೃಹತ್ ದೇವದಾರು ಮರವಿತ್ತು. ಅದು ಸದಾ ಕೆಳಗಿದ್ದ ಪುಟ್ಟ ಹುಲ್ಲನ್ನು ಕಂಡು ಅಹಂಕಾರದಿಂದ ಹೀಯಾಳಿಸುತ್ತಿತ್ತು.",
                    "Ondu dodda udyaanadalli bruhat devadaaru maravittu. Adu sadaa kelagidda putta hullannu kandu ahamkaaradinda heeyaalisuttittu.",
                    "In an emerald valley stood a towering tree boastful of its height, continually scorning the quiet tender grass beneath.",
                    "ഒരു വലിയ പൂന്തോട്ടത്തിൽ ഉയരം കൂടിയ ഒരു മരമുണ്ടായിരുന്നു. അത് താഴെയുള്ള കൊച്ചു പുല്ലുകളെ നോക്കി അഹങ്കരിച്ചു.",
                    "Oru valiya poonthoattathil uyaram koodiya oru maramundaayirunnu. Athu thaazheyulla kochu pullukale nokki ahankarichu."
                ),
                StoryParagraph(
                    2,
                    "'तुम कितने छोटे और मामूली हो!' देवदार गरजता, 'देखो मैं बादलों से बातें करता हूँ और मेरी शान सबसे निराली है।'",
                    "'Tum kitne chhote aur maamooli ho!' Devdaar garajta, 'Dekho main baadlon se baatein karta hoon aur meri shaan sabse niraali hai.'",
                    "'ನೀವು ಎಷ್ಟು ಕ್ಷುಲ್ಲಕರು!' ಮರವು ಗರ್ಜಿಸಿತು, 'ನೋಡಿ ನಾನು ಮೋಡಗಳೊಂದಿಗೆ ಮಾತನಾಡುತ್ತೇನೆ, ನನ್ನ ವೈಭವವೇ ಬೇರೆ.'",
                    "'Neevu eshtu kshullakaru!' Maravu garjisitu, 'Nodi naanu modagalondige maatanaaduttene, nanna vaibhavave bere.'",
                    "'Look how humble and hidden you are!' boasted the mighty boughs. 'I touch the clouds and command everyone's gaze!'",
                    "'നിങ്ങൾ എത്ര നിസ്സാരരാണ്!' മരം പറഞ്ഞു, 'നോക്കൂ, ഞാൻ മേഘങ്ങളെ തൊടുന്നു, എന്റെ പ്രൗഢി ആർക്കുമില്ല.'",
                    "'Ningal ethra nissaararaanu!' Maram paranju, 'Nokkoo, njaan meghangale thodunnu, ente proudhi aarkkumilla.'"
                ),
                StoryParagraph(
                    3,
                    "नन्हीं दूब मुस्कुराती और चुपचाप ज़मीन से जुड़ी रहती। एक दिन अचानक भीषण चक्रवात उठा। हवा की गति इतनी प्रचंड थी कि धरती काँप उठी।",
                    "Nanhi doob muskuraati aur chupchaap zameen se judi rehti. Ek din aachanak bheeshan chakravaat utha. Hawa ki gati itni prachand thi ki dharti kaanp uthi.",
                    "ಪುಟ್ಟ ಹುಲ್ಲು ಸಮಾಧಾನದಿಂದ ನೆಲದಲ್ಲೇ ನಮ್ರವಾಗಿ ನಿಂತಿತ್ತು. ಒಂದು ದಿನ ರಣಭೀಕರ ಬಿರುಗಾಳಿ ಬೀಸಿತು. ಭೂಮಿಯೇ ನಡುಗುವಂತಾಯಿತು.",
                    "Putta hullu samaadhaanadinda neladalle namravaagi nintittu. Ondu dina ranabheekara birugaali beesitu. Bhoomiye naduguvantaayitu.",
                    "The grass simply smiled, rooted deeply and modestly. Then arrived a fierce gale with howling winds that shook the mountains.",
                    "പുല്ലുകൾ വിനയത്തോടെ തലകുനിച്ചു നിന്നു. അപ്പോൾ അവിടേക്ക് ഭയങ്കരമായ കൊടുങ്കാറ്റ് ആഞ്ഞുവീശി.",
                    "Pullukal vinayathode thalakunichu ninnu. Appol avidekku bhayankaramaaya kodunkaattu aanjuveeshi."
                ),
                StoryParagraph(
                    4,
                    "घमंडी देवदार अकड़कर खड़ा रहा, और हवा के एक ही प्रचंड झोंके ने उसे जड़ से उखाड़कर ज़मीन पर पटक दिया।",
                    "Ghamandi devdaar akadkar khada raha, aur hawa ke ek hi prachand jhonke ne usey jad se ukhaadkar zameen par patak diya.",
                    "ಅಹಂಕಾರಿ ಮರವು ಬಿರುಸಾಗಿ ಸೆಟೆದು ನಿಂತಿತು, ಆದರೆ ಬಿರುಗಾಳಿಯ ರಭಸಕ್ಕೆ ಬುಡಸಮೇತ ಮುರಿದು ನೆಲಕ್ಕುರುಳಿತು.",
                    "Ahamkaari maravu birusaagi setedu nintitu, aadare birugaaliya rabhasakke budasameta muridu nelakkurulitu.",
                    "The stiff tree refused to bend, and a violent gust snapped its trunk, toppling it crashing to the dirt.",
                    "തടിയുയർത്തി നിന്ന അഹങ്കാരിയായ മരം കൊടുങ്കാറ്റിന്റെ ശക്തിയിൽ കടപുഴകി നിലംപതിച്ചു.",
                    "Thadiyuyartthi ninna ahankaariyaaya maram kodunkaattinte shakthiyil kadapuzhaki nilampathichu."
                ),
                StoryParagraph(
                    5,
                    "नन्हीं दूब हवा के साथ झुक गई थी, इसलिए वह सुरक्षित रही। तूफान थमा तो वह फिर खिली। सादगी और विनम्रता ही सबसे सुरक्षित ढाल हैं।",
                    "Nanhi doob hawa ke saath jhuk gayi thi, isliye woh surakshit rahi. Toofaan thama to woh phir khili. Saadgi aur vinamrata hi sabse surakshit dhaal hain.",
                    "ನಮ್ರವಾಗಿದ್ದ ಪುಟ್ಟ ಹುಲ್ಲು ಗಾಳಿಗೆ ಬಾಗಿದ್ದರಿಂದ ಸುರಕ್ಷಿತವಾಗಿ ಉಳಿಯಿತು. ಸರಳತೆ ಮತ್ತು ವಿನಯವೇ ನಿಜವಾದ ಶಕ್ತಿ ಎಂದು ಸಾರಿತು.",
                    "Namravaagidda putta hullu gaalige baagiddarinda surakshitavaagi uliyitu. Saralate mattu vinayave nijaavada shakti endu saaritu.",
                    "The tender grass bowed gracefully with the gusts and stood radiant when dawn returned. Humility bends with life's winds and remains unbroken.",
                    "കാറ്റിനൊപ്പം കുനിഞ്ഞു കൊടുത്ത കൊച്ചുപുല്ലുകൾ കേടുകൂടാതെ നിന്നു. വിനയമാണ് ആപത്തുകളിൽ ഏറ്റവും വലിയ കവചം.",
                    "Kaattinappam kuninju kodutha kochupullukal kedukoodaathe ninnu. Vinayamaanu aapathukalil ettavum valiya kavacham."
                )
            )

            "Confidence & Self-Belief" -> listOf(
                StoryParagraph(
                    1,
                    "एक छोटे पंछी को हमेशा डर लगता था कि उसके पंख कमज़ोर हैं और वह खुले आसमान में नहीं उड़ पाएगा।",
                    "Ek chhote panchhi ko hamesha dar lagta tha ki uske pankh kamzor hain aur woh khule aasmaan me nahi ud paayega.",
                    "ಪುಟ್ಟ ಹಕ್ಕಿಯೊಂದಕ್ಕೆ ತನ್ನ ರೆಕ್ಕೆಗಳು ಬಲಹೀನವಾಗಿವೆ, ಆಕಾಶದಲ್ಲಿ ಹಾರಲು ಸಾಧ್ಯವಿಲ್ಲ ಎಂಬ ಅಂಜಿಕೆಯಿತ್ತು.",
                    "Putta hakkiyondakke tanna rekkegalu balaheenavaagive, aakaashadalli haaralu saadhyavilla emba anjikeyittu.",
                    "A fledgling bird gazed down from high branches, afraid that its small wings could never support flight through the wide blue sky.",
                    "തന്റെ ചിറകുകൾക്ക് ശക്തിയില്ലെന്നും പറക്കാൻ കഴിയില്ലെന്നും ഒരു കുഞ്ഞുപക്ഷി എപ്പോഴും ഭയപ്പെട്ടിരുന്നു.",
                    "Thante chirakukalkku shakthiyillennum parakkaan kazhiyillennum oru kunjupakshi eppozhum bhayappettirunnu."
                ),
                StoryParagraph(
                    2,
                    "दूसरे पंछी खुशी से दूर-दूर उड़ते, जबकि वह घोंसले के कोने में दुबका रहता और अपनी तुलना दूसरों से करता।",
                    "Doosre panchhi khushi se door-door udte, jabki woh ghosle ke kone me dubka rehta aur apni tulna doosron se karta.",
                    "ಇತರ ಹಕ್ಕಿಗಳು ದೂರ ದೂರ ಹಾರಾಡುತ್ತಿದ್ದವು, ಆದರೆ ಇದು ಮಾತ್ರ ಮೂಲೆಯಲ್ಲಿ ಕುಳಿತು ತನ್ನನ್ನು ಇತರರೊಂದಿಗೆ ಹೋಲಿಸುತ್ತಿತ್ತು.",
                    "Itara hakkigalu doora doora haaraaduttiddavu, aadare idu maatra mooleyalli kulitu tannannu itararondige holisuttittu.",
                    "While flockmates soared across the clouds, it trembled by the nest, continually measuring itself against others with self-doubt.",
                    "മറ്റു പക്ഷികൾ ആകാശത്ത് പാറിനടന്നപ്പോൾ ഈ കുഞ്ഞുപക്ഷി കൂട്ടിൽ ഒതുങ്ങിക്കൂടി സങ്കടപ്പെട്ടു.",
                    "Matthu pakshikal aakaashath paarinadannappol ee kunjupakshi koottil othungikkoodi sankadappettu."
                ),
                StoryParagraph(
                    3,
                    "माँ ने उसे पास बुलाकर कहा, 'बेटा, तुम्हें पेड़ की डाली पर नहीं, बल्कि अपने अंदर छिपे ईश्वर के उपहार पर भरोसा रखना है।' ",
                    "Maa ne usey paas bulaakar kaha, 'Beta, tumhein ped ki daali par nahi, balki apne andar chhipe ishwar ke upahaar par bharosa rakhna hai.'",
                    "ತಾಯಿ ಹಕ್ಕಿ ಪ್ರೀತಿಯಿಂದ, 'ಮಗುವೇ, ಮರದ ಕೊಂಬೆಯ ಮೇಲಲ್ಲ, ನಿನ್ನೊಳಗಿನ ದೈವಿಕ ಸಾಮರ್ಥ್ಯದ ಮೇಲೆ ನಂಬಿಕೆಯಿಡು' ಎಂದು ಹುರಿದುಂಬಿಸಿತು.",
                    "Taayi hakki preetiyinda, 'Maguve, marada kombeya melalla, ninnolagina daivika saamarthyada mele nambikeyidu' endu huridumbisitu.",
                    "The mother gently whispered, 'Do not trust the frail branch under your feet; trust the infinite grace placed within your own wings.'",
                    "അമ്മ പക്ഷി സ്നേഹത്തോടെ പറഞ്ഞു, 'മകനേ, മരച്ചില്ലയിലല്ല, നിന്റെ സ്വന്തം ചിറകുകളിലാണ് നീ വിശ്വസിക്കേണ്ടത്.'",
                    "Amma pakshi snehathode paranju, 'Makane, marachillayilalla, ninte swantham chirakukalilaanu nee vishwasikkendathu.'"
                ),
                StoryParagraph(
                    4,
                    "उसने अपनी आँखें बंद कीं, गहरे आत्मविश्वास से पंख फैलाए और निडर होकर हवा में छलांग लगा दी।",
                    "Usne apni aankhein band keen, gehre aatmavishvaas se pankh phailaaye aur nidar hokar hawa me chhalaang laga di.",
                    "ಅದು ಕಣ್ಣು ಮುಚ್ಚಿ, ದೃಢ ಆತ್ಮವಿಶ್ವಾಸದಿಂದ ರೆಕ್ಕೆ ಬಿಚ್ಚಿ ನಿರ್ಭಯವಾಗಿ ಗಾಳಿಯಲ್ಲಿ ಜಿಗಿಯಿತು.",
                    "Adu kannu mucchi, drudha aatmavishvaasadinda rekke bicchi nirbhayavaagi gaaliyalli jigiyitu.",
                    "Taking a deep breath, the little bird spread its feathers wide, silenced the voices of fear, and leapt boldly into the open breeze.",
                    "അത് ഭയം വെടിഞ്ഞ്, ആത്മവിശ്വാസത്തോടെ ചിറകടിച്ചു വായുവിൽ പറന്നുയർന്നു.",
                    "Athu bhayam vedinju, aathmavishwasathode chirakadichu vaayuvil parannuyarnnu."
                ),
                StoryParagraph(
                    5,
                    "हवा ने उसके पंखों को थामा और वह ऊँचाइयों में उड़ने लगा। विश्वास डर से कहीं अधिक बलवान होता है।",
                    "Hawa ne uske pankhon ko thaama aur woh oonchaaiyon me udne laga. Vishvaas dar se kahin adhik balwaan hota hai.",
                    "ಗಾಳಿಯು ಅದರ ರೆಕ್ಕೆಗಳಿಗೆ ಆಧಾರವಾಯಿತು, ಅದು ಆನಂದದಿಂದ ಮುಗಿಲೆತ್ತರಕ್ಕೆ ಹಾರಿತು. ನಂಬಿಕೆಯು ಭಯಕ್ಕಿಂತ ಶಕ್ತಿಶಾಲಿ!",
                    "Gaaliyu adara rekkegalige aadhaaravaayitu, adu aanandadinda mugilettharakke haaritu. Nambikeyu bhayakkinta shaktishaali!",
                    "The warm currents caught its feathers, and suddenly it was gliding above the forest canopy. Self-belief dissolves fear instantly.",
                    "കാറ്റ് അതിനെ താങ്ങിനിർത്തി, അത് ആകാശത്ത് ഉയർന്നു പറന്നു. ആത്മവിശ്വാസത്തിന് ഏത് ഭയത്തെയും തോൽപ്പിക്കാനാകും.",
                    "Kaattu athine thaangininirthi, athu aakaashath uyarnnu parannu. Aathmavishwasathinu ethu bhayaththeyum tholppikkaanaakum."
                )
            )

            "Regular Practice & Discipline" -> listOf(
                StoryParagraph(
                    1,
                    "प्राचीन गुरुकुल में वरदराज नाम का एक शिष्य था, जिसे जो भी पढ़ाया जाता, वह तुरंत भूल जाता था।",
                    "Praacheen gurukul me Varadraaj naam ka ek shishya tha, jise jo bhi padhaaya jaata, woh turant bhool jaata tha.",
                    "ಪ್ರಾಚೀನ ಗುರುಕುಲದಲ್ಲಿ ವರದರಾಜನೆಂಬ ಶಿಷ್ಯನಿದ್ದನು, ಅವನು ಕಲಿಯುವ ವಿಷಯಗಳು ಅವನಿಗೆ ತಕ್ಷಣ ಮರೆತುಹೋಗುತ್ತಿದ್ದವು.",
                    "Praacheena gurukuladalli Varadraajanemba shishyaniddanu, avanu kaliyuva vishayagalu avanige takshana maretuhoguttiddavu.",
                    "In an ancient school lived young Varadaraja, who struggled to memorize verses and felt disheartened by his slow progress.",
                    "ഒരു പഴയ ഗുരുകുലത്തിൽ വരദരാജൻ എന്നൊരു ശിഷ്യനുണ്ടായിരുന്നു, പഠിച്ച കാര്യങ്ങൾ അവൻ പെട്ടെന്ന് മറന്നുപോയിരുന്നു.",
                    "Oru pazhaya gurukulathil Varadaraajan ennoru shishyanundaayirunnu, padicha kaaryangal avan pettennu marannupoyirunnu."
                ),
                StoryParagraph(
                    2,
                    "साथी छात्र आगे बढ़ गए, और वह बहुत उदास होकर कुएं के पास पानी पीने रुका।",
                    "Saathi chhaatra aage badh gaye, aur woh bahut udaas hokar kuen ke paas paani peene ruka.",
                    "ಸಹಪಾಠಿಗಳು ಮುನ್ನಡೆದರು, ಅವನು ನೊಂದುಕೊಂಡು ನೀರು ಕುಡಿಯಲು ಬಾವಿಯ ಬಳಿ ತೆರಳಿದನು.",
                    "Sahapaathigalu munnadedaru, avanu nondukondu neeru kudiyalu baaviya bali teralidanu.",
                    "Fellow classmates advanced while he sat lonely near a stone well, questioning if he had any capacity for learning.",
                    "സഹപാഠികൾ മുന്നേറിയപ്പോൾ അവൻ വിഷമത്തോടെ വെള്ളം കുടിക്കാൻ കിണറ്റിൻകരയിലെത്തി.",
                    "Sahapaadhikal munneriyappol avan vishamathode vellam kudikkaan kinattinkarayiletthi."
                ),
                StoryParagraph(
                    3,
                    "वहाँ उसने देखा कि नरम रस्सी के बार-बार घिसने से कठोर काले पत्थर पर भी गहरा निशान बन गया था।",
                    "Wahaan usne dekha ki naram rassi ke baar-baar ghisne se kathor kaale patthar par bhi gehra nishaan ban gaya tha.",
                    "ಅಲ್ಲಿ ಆಶ್ಚರ್ಯದಿಂದ ನೋಡಿದಾಗ, ಮೃದುವಾದ ಹಗ್ಗವು ನಿರಂತರವಾಗಿ ಉಜ್ಜಿದ್ದರಿಂದ ಗಟ್ಟಿ ಕಲ್ಲಿನ ಮೇಲೂ ಆಳವಾದ ಗೆರೆ ಮೂಡಿತ್ತು.",
                    "Alli aashcharyadinda nodidaaga, mruduvaada haggavu nirantaravaagi ujjiddarinda gatti kallina meloo aalavaada gere moodittu.",
                    "Looking closely at the well curb, he noticed deep grooves etched into hard stone by the repeated rubbing of a soft hemp rope.",
                    "അവിടെ അവൻ കണ്ടു, മൃദുവായ കയർ നിരന്തരം ഉരസിയതുകൊണ്ട് കരിങ്കല്ലിൽ പോലും ആഴത്തിൽ പാടുകൾ വീണിരിക്കുന്നു.",
                    "Avide avan kandu, mruduvaaya kayar nirantharam urasiyathukondu karinkallil polum aazhathil paadukal veenirikkunnu."
                ),
                StoryParagraph(
                    4,
                    "उसने सोचा, 'जब कोमल रस्सी पत्थर को काट सकती है, तो क्या निरंतर अभ्यास से मेरा मन विद्या ग्रहण नहीं कर सकता?'",
                    "Usne socha, 'Jab komal rassi patthar ko kaat sakti hai, to kya nirantar abhyaas se mera man vidya grahan nahi kar sakta?'",
                    "'ಕೋಮಲ ಹಗ್ಗವೇ ಕಲ್ಲನ್ನು ಸೀಳಬಲ್ಲದಾದರೆ, ದಿನನಿತ್ಯದ ಸತತ ಅಭ್ಯಾಸದಿಂದ ನನ್ನ ಬುದ್ಧಿ ಜ್ಞಾನ ಪಡೆಯಲಾರದೆ?' ಎಂದು ಯೋಚಿಸಿದನು.",
                    "'Komala haggave kallannu seelaballadaadare, dinanityada satata abhyaasadinda nanna buddhi jnaana padeyalaarade?' endu yochisidanu.",
                    "A spark ignited his mind: 'If soft hemp can groove solid granite through repetition, cannot constant practice awaken my intellect?'",
                    "'മൃദുവായ കയറിന് കല്ലിനെ തുരക്കാമെങ്കിൽ, നിരന്തര പരിശീലനത്തിലൂടെ എനിക്കും വിദ്യ നേടാനാകില്ലേ?' അവൻ ചിന്തിച്ചു.",
                    "'Mruduvaaya kayarinu kalline thurakkaamengil, niranthara parisheelanathiloode enikkum vidya nedanaakille?' avan chinthichu."
                ),
                StoryParagraph(
                    5,
                    "उसने रोज़ नियम से अध्ययन करना शुरू किया। वही वरदराज आगे चलकर महान विद्वान और व्याकरण के रचयिता बने। अभ्यास ही सफलता की चाबी है।",
                    "Usne roz niyam se adhyayan karna shuru kiya. Wahi Varadraaj aage chalkar mahaan vidwaan aur vyaakaran ke rachayita bane. Abhyaas hi saphalta ki chaabi hai.",
                    "ಅವನು ಪ್ರತಿದಿನ ತಪ್ಪದೆ ಅಭ್ಯಾಸ ಮಾಡಿದನು. ಮುಂದೆ ಅವನೇ ಶ್ರೇಷ್ಠ ವಿದ್ವಾಂಸನಾಗಿ ಪ್ರಸಿದ್ಧಿ ಪಡೆದನು. ನಿರಂತರ ಅಭ್ಯಾಸವೇ ಜಯದ ಹಾದಿ!",
                    "Avanu pratidina tappade abhyaasa maadidanu. Munde avane shreshta vidvaamsanaagi prasiddhi padedanu. Nirantara abhyaasave jayada haadi!",
                    "He dedicated himself to regular, disciplined practice every single day, eventually rising to become one of history's greatest scholars.",
                    "അവൻ നിത്യേന ചിട്ടയോടെ പഠിച്ചു. പിന്നീട് അവൻ വലിയൊരു പണ്ഡിതനായി മാറി. നിരന്തര പരിശീലനമാണ് വിജയത്തിന്റെ രഹസ്യം.",
                    "Avan nithyena chittayode padichu. Pinnedu avan valiyoru pandithanaayi maari. Niranthara parisheelanamaanu vijayathinte rahasyam."
                )
            )

            else -> listOf(
                StoryParagraph(
                    1,
                    "एक सुंदर और शांत प्रदेश में यह प्राचीन कथा शुरू होती है। चारों ओर हरियाली और आनंद का वातावरण था।",
                    "Ek sundar aur shaant pradesh me yeh praacheen katha shuru hoti hai. Chaaron or hariyaali aur aanand ka vaataavaran tha.",
                    "ಒಂದು ಸುಂದರ ಮತ್ತು ಪ್ರಶಾಂತ ತಾಣದಲ್ಲಿ ಈ ಪ್ರಾಚೀನ ಕಥೆ ಆರಂಭವಾಗುತ್ತದೆ. ಸುತ್ತಲೂ ಹಸಿರು ಮತ್ತು ಸಂತಸದ ವಾತಾವರಣವಿತ್ತು.",
                    "Ondu sundara mattu prashaanta taanadalli ee praacheena kathe aarambhavaaguttade. Suttaloo hasiru mattu santasada vaataavaranavittu.",
                    "In a serene and picturesque land, this timeless tale of wisdom begins. Nature was peaceful, and every creature lived in harmony.",
                    "മനോഹരവും ശാന്തവുമായ ഒരു പ്രദേശത്താണ് ഈ പുരാതന കഥ ആരംഭിക്കുന്നത്. എങ്ങും പച്ചപ്പും സന്തോഷവും നിറഞ്ഞുനിന്നിരുന്നു.",
                    "Manoharavum shanthavumaya oru pradheshathaanu ee purathana katha aarambhikkunnathu. Engum pachappum santhoshavum niranju ninnirunnu."
                ),
                StoryParagraph(
                    2,
                    "यहाँ रहने वाले सभी पात्र बहुत समझदार और परिश्रमी थे। वे हर दिन एक नई सीख और अनुभव प्राप्त करते थे।",
                    "Yahaan rehne waale sabhi paatra bahut samajhdaar aur parishrami the. We har din ek nayi seekh aur anubhav praapt karte the.",
                    "ಇಲ್ಲಿ ವಾಸಿಸುತ್ತಿದ್ದ ಎಲ್ಲರೂ ಬಹಳ ಬುದ್ಧಿವಂತರು ಮತ್ತು ಪರಿಶ್ರಮಿಗಳಾಗಿದ್ದರು. ಅವರು ಪ್ರತಿದಿನ ಹೊಸ ಹೊಸ ವಿಷಯಗಳನ್ನು ಕಲಿಯುತ್ತಿದ್ದರು.",
                    "Illi vaasisuttidda ellaroo bahala buddhivantaru mattu parishramigalaagiddaru. Avaru pratidina hosa hosa vishayagalannu kaliyuttiddaru.",
                    "The characters here were diligent and thoughtful, always seeking knowledge and learning meaningful lessons from daily life.",
                    "ഇവിടെ ജീവിച്ചിരുന്ന എല്ലാവരും വളരെ ബുദ്ധിമാന്മാരും കഠിനാധ്വാനികളുമായിരുന്നു. അവർ ദിവസവും പുതിയ പാഠങ്ങൾ പഠിച്ചിരുന്നു.",
                    "Ivide jeevichirunna ellaavarum valare buddhimaanmaarum kathinaadhwaanikalumaayirunnu. Avar dhivasavum puthiya paadhangal padichirunnu."
                ),
                StoryParagraph(
                    3,
                    "एक दिन अचानक एक बड़ी चुनौती सामने आई। सभी लोग चिंता में पड़ गए कि इसका समाधान कैसे निकाला जाए।",
                    "Ek din aachanak ek badi chunauti saamne aayi. Sabhi log chinta me pad gaye ki iska samaadhaan kaise nikaala jaaye.",
                    "ಒಂದು ದಿನ ಅನಿರೀಕ್ಷಿತವಾಗಿ ಒಂದು ದೊಡ್ಡ ಸವಾಲು ಎದುರಾಯಿತು. ಇದಕ್ಕೆ ಸೂಕ್ತ ಪರಿಹಾರವನ್ನು ಹೇಗೆ ಕಂಡುಕೊಳ್ಳುವುದೆಂದು ಎಲ್ಲರೂ ಯೋಚಿಸತೊಡಗಿದರು.",
                    "Ondu dina anireekshitavaagi ondu dodda savaalu eduraayitu. Idakke sookta parihaaravannu hege kandukolluvudendu ellaroo yochisatodagidaru.",
                    "One day, an unexpected difficulty arose that tested everyone's patience and wit. They gathered to find a peaceful resolution.",
                    "ഒരു ദിവസം പെട്ടെന്ന് ഒരു വലിയ വെല്ലുവിളി നേരിടേണ്ടി വന്നു. ഇതിന് എങ്ങനെ പരിഹാരം കണ്ടെത്താമെന്ന് എല്ലാവരും ചിന്തിക്കാൻ തുടങ്ങി.",
                    "Oru dhivasam pettennu oru valiya velluvili neredendi vannu. Ithinu engane parihaaram kandethamennu ellaavarum chinthikkaan thudangi."
                ),
                StoryParagraph(
                    4,
                    "धैर्य और आपसी समझ से काम लेते हुए, उन्होंने बुद्धिमान सलाह का पालन किया और मिलकर प्रयास किया।",
                    "Dhairya aur aapsi samajh se kaam lete hue, unhone buddhimaan salaah ka paalan kiya aur milkar prayaas kiya.",
                    "ತಾಳ್ಮೆ ಮತ್ತು ಪರಸ್ಪರ ಸಹಕಾರದಿಂದ, ಅವರು ಜ್ಞಾನಿಗಳ ಹಿತನುಡಿಯನ್ನು ಪಾಲಿಸಿ ಒಗ್ಗಟ್ಟಾಗಿ ಶ್ರಮಿಸಿದರು.",
                    "Taalme mattu paraspara sahakaaradinda, avaru jnaanigala hitanudiyannu paarisi oggattaagi shramisidaru.",
                    "With patience, deep understanding, and mutual cooperation, they listened to wise counsel and worked together hand-in-hand.",
                    "ക്ഷമയോടും പരസ്പര സഹകരണത്തോടും കൂടി, അവർ ജ്ഞാനികളുടെ ഉപദേശം സ്വീകരിച്ച് ഒത്തൊരുമിച്ച് പ്രവർത്തിച്ചു.",
                    "Kshamayodum paraspara sahakarana thodum koodi, avar jnaanikalude upadhesham sweekarithu oththorumithu pravarthichu."
                ),
                StoryParagraph(
                    5,
                    "अंत में सच्चाई, विनम्रता और बुद्धिमानी की विजय हुई। सभी ने एक दूसरे का आभार माना और खुशी से रहने लगे।",
                    "Ant me sachhaai, vinamrata aur buddhimaani ki vijay hui. Sabhi ne ek doosre ka aabhaar maana aur khushi se rehne lage.",
                    "ಕೊನೆಗೆ ಸತ್ಯ, ನಮ್ರತೆ ಮತ್ತು ಜಾಣ್ಮೆಗೆ ಜಯ ಸಿಕ್ಕಿತು. ಎಲ್ಲರೂ ಪರಸ್ಪರ ಧನ್ಯವಾದ ಹೇಳಿ ಸಂತಸದಿಂದ ಜೀವನ ಮುಂದುವರಿಸಿದರು.",
                    "Konege satya, namrate mattu jaanmege jaya sikkitu. Ellaroo paraspara dhanyavaada heli santasadinda jeevana munduvarisidaru.",
                    "In the end, truth, humility, and clever insight triumphed. Everyone thanked one another warmly and lived happily ever after.",
                    "ഒടുവിൽ സത്യത്തിനും വിനയത്തിനും ബുദ്ധിക്കും വിജയം ലഭിച്ചു. എല്ലാവരും പരസ്പരം നന്ദി പറഞ്ഞ് സന്തോഷത്തോടെ ജീവിച്ചു.",
                    "Oduvil satyathinum vinayathinum buddhikkum vijayam labhichu. Ellaavarum parasparam nandi paranju santhoshathode jeevichu."
                )
            )
        }
    }

    private fun generateMoralForCategory(category: String, title: String): StoryMoral {
        return when (category) {
            "Motivational & Keep Going" -> StoryMoral(
                "गिरने से मत डरो, उठो और आगे बढ़ते रहो। निरंतर प्रयास ही विजय दिलाता है।",
                "Girne se mat daro, utho aur aage badhte raho. Nirantar prayaas hi vijay dilaata hai.",
                "ಸೋಲಿಗೆ ಹೆದರಬೇಡ, ಮತ್ತೆದ್ದು ಮುನ್ನಡೆ. ನಿರಂತರ ಪರಿಶ್ರಮವೇ ಜಯದ ಹಾದಿ.",
                "Solige hedarabeda, matteddu munnade. Nirantara parishramave jayada haadi.",
                "Never give up, keep going forward. Resilience turns every setback into stepping stones for success.",
                "തളർന്നു വീഴരുത്, എഴുന്നേറ്റു മുന്നേറുക. നിരന്തര പരിശ്രമം വിജയം സമ്മാനിക്കും.",
                "Thalarnnu veezharuthu, ezhunnettu munneruka. Niranthara parishramam vijayam sammaanikkum."
            )
            "Gratitude & Thankfulness" -> StoryMoral(
                "जो हमारे पास है, उसके लिए धन्यवाद देना ही सच्चे सुख और शांति की कुंजी है।",
                "Jo hamare paas hai, uske liye dhanyavaad dena hi sachhe sukh aur shaanti ki kunji hai.",
                "ನಮ್ಮಲ್ಲಿರುವ ಒಳಿತಿಗೆ ಕೃತಜ್ಞತೆ ಸಲ್ಲಿಸುವುದೇ ನಿಜವಾದ ಸಂತೋಷ ಮತ್ತು ನೆಮ್ಮದಿಯ ಗುಟ್ಟು.",
                "Nammalliruva olitige kritajnate sallisuvude nijaavada santossha mattu nemmadiya guttu.",
                "Gratitude turns what little we have into abundance, filling the heart with lasting joy.",
                "ഉള്ളതിന് നന്ദി പറയുന്നതിലാണ് ജീവിതത്തിന്റെ യഥാർത്ഥ ആനന്ദവും സമാധാനവും.",
                "Ullathinu nandi parayunnathilaanu jeevithathinte yathaartha aanandavum samaadhaanavum."
            )
            "Respect & Elders" -> StoryMoral(
                "माता-पिता, गुरु और बड़ों का सम्मान करना ही सबसे बड़ा संस्कार और जीवन का आधार है।",
                "Maata-pita, guru aur badon ka sammaan karna hi sabse bada sanskaar aur jeevan ka aadhaar hai.",
                "ತಂದೆ-ತಾಯಿ, ಗುರು ಮತ್ತು ಹಿರಿಯರನ್ನು ಗೌರವಿಸುವುದೇ ಶ್ರೇಷ್ಠ ಸಂಸ್ಕಾರ ಮತ್ತು ಜೀವನದ ಅಡಿಪಾಯ.",
                "Tande-taayi, guru mattu hiriyarannu gauravisuvude shreshta samskaara mattu jeevanada adipaaya.",
                "Honoring parents, teachers, and elders builds character, wisdom, and lasting virtue.",
                "മാതാപിതാക്കളെയും ഗുരുക്കന്മാരെയും മുതിർന്നവരെയും ആദരിക്കുക എന്നത് ഉത്തമ സംസ്കാരമാണ്.",
                "Maathaapithaakkaleyum gurukkanmaareyum muthirnavareyum aadarikkuka ennathu uthama samskaaramaanu."
            )
            "Grounded & Humility" -> StoryMoral(
                "सच्ची महानता विनम्रता और सादगी में है, दिखावे और घमंड में नहीं।",
                "Sachhi mahaanta vinamrata aur saadgi me hai, dikhaawe aur ghamand me nahi.",
                "ನಿಜವಾದ ಶ್ರೇಷ್ಠತೆಯು ವಿನಯತೆ ಮತ್ತು ಸರಳತೆಯಲ್ಲಿದೆ, ಆಡಂಬರ ಮತ್ತು ಅಹಂಕಾರದಲ್ಲಲ್ಲ.",
                "Nijaavada shreshtateyu vinayate mattu saralateyallide, aadambara mattu ahamkaaradallalla.",
                "Stay grounded and humble. True greatness shines without boasting or showmanship.",
                "യഥാർത്ഥ മഹത്വം വിനയത്തിലും ലാളിത്യത്തിലുമാണ്, പൊങ്ങച്ചത്തിലും അഹങ്കാരത്തിലുമല്ല.",
                "Yathaartha mahathwam vinayathilum laalithyathilumaanu, pongachathilum ahankaarathilumalla."
            )
            "Confidence & Self-Belief" -> StoryMoral(
                "खुद पर सच्चा विश्वास रखो और निडर होकर आगे बढ़ो। आत्मविश्वास से हर राह आसान होती है।",
                "Khud par sachha vishvaas rakho aur nidar hokar aage badho. Aatmavishvaas se har raah aasaan hoti hai.",
                "ನಿನ್ನ ಸಾಮರ್ಥ್ಯದ ಮೇಲೆ ನಿನಗೆ ಅಚಲ ನಂಬಿಕೆಯಿರಲಿ. ಆತ್ಮವಿಶ್ವಾಸದಿಂದ ಎಲ್ಲ ಅಡೆತಡೆಗಳನ್ನೂ ಜಯಿಸಬಹುದು.",
                "Ninna saamarthyada mele ninage achala nambikeyirali. Aatmavishvaasadinda ella adetadegalannoo jayisabahudu.",
                "Believe in yourself with quiet courage. Confidence turns the impossible into reality.",
                "നിങ്ങളിൽ തന്നെ പൂർണ്ണമായി വിശ്വസിക്കുക. ആത്മവിശ്വാസമാണ് ഏറ്റവും വലിയ വിജയരഹസ്യം.",
                "Ningalil thanne poornnamaayi vishwasikkuka. Aathmavishwasamaanu ettavum valiya vijayarahasyam."
            )
            "Regular Practice & Discipline" -> StoryMoral(
                "करत-करत अभ्यास के जड़मति होत सुजान। रोज़ का नियम और परिश्रम ही महानता रचता है।",
                "Karat-karat abhyaas ke jadmati hot sujaan. Roz ka niyam aur parishram hi mahaanta rachta hai.",
                "ನಿರಂತರ ಅಭ್ಯಾಸದಿಂದ ಕಷ್ಟವೂ ಸುಲಭವಾಗುತ್ತದೆ. ದಿನನಿತ್ಯದ ಸಣ್ಣ ಪ್ರಯತ್ನವೇ ದೊಡ್ಡ ಸಾಧನೆಗೆ ಮುನ್ನುಡಿ.",
                "Nirantara abhyaasadinda kashtavoo sulabhavaaguttade. Dinanityada sanna prayatnave dodda saadhanege munnudi.",
                "Daily regular practice turns struggle into effortless mastery. Consistency is the master key.",
                "ദിനവുമുള്ള നിരന്തര പരിശീലനത്തിലൂടെ ഏത് വലിയ കാര്യവും അനായാസം നേടിയെടുക്കാം.",
                "Dinavumulla niranthara parisheelanathiloode ethu valiya kaaryavum anaayaasam nediyedukkaam."
            )
            "Panchatantra" -> StoryMoral(
                "जहाँ बल काम न आए, वहाँ बुद्धि काम आती है।",
                "Jahaan bal kaam na aaye, wahaan buddhi kaam aati hai.",
                "ಶಕ್ತಿಗಿಂತ ಯುಕ್ತಿ ಲೇಸು.",
                "Shaktiginta yukti lesu.",
                "Wisdom and intelligence are mightier than brute physical force.",
                "കായിക ബലത്തേക്കാൾ വലുതാണ് ബുദ്ധിശക്തി.",
                "Kaayika balaththekkal valuthaanu buddhishakthi."
            )
            "Akbar & Birbal" -> StoryMoral(
                "सत्य और न्याय को कभी छिपाया नहीं जा सकता।",
                "Satya aur nyaay ko kabhi chhipaaya nahi ja sakta.",
                "ಸತ್ಯ ಮತ್ತು ನ್ಯಾಯಕ್ಕೆ ಎಂದಿಗೂ ಅಳಿವಿಲ್ಲ.",
                "Satya mattu nyaayakke endigoo alivilla.",
                "Truth and justice will always shine brightly through wisdom.",
                "സത്യത്തെയും നീതിയെയും ഒരിക്കലും മറച്ചുവെക്കാനാവില്ല.",
                "Satyaththeyum neethiyeyum orikkalum marachuvekkaanaavilla."
            )
            "Tenali Rama" -> StoryMoral(
                "शांत दिमाग और हास्य से हर मुश्किल आसान हो जाती है।",
                "Shaant dimaag aur haasya se har mushkil aasaan ho jaati hai.",
                "ಶಾಂತ ಚಿತ್ತ ಮತ್ತು ಸಮಯಪ್ರಜ್ಞೆಯಿಂದ ಎಂತಹ ಕಷ್ಟವೂ ಸುಲಭವಾಗುತ್ತದೆ.",
                "Shaanta chitta mattu samayaprajneyinda entaha kashtavoo sulabhavaaguttade.",
                "A calm mind and quick wit can solve the toughest dilemmas.",
                "ശാന്തമായ മനസ്സും സമയോചിതമായ ബുദ്ധിയും ഏത് പ്രതിസന്ധിയും പരിഹരിക്കും.",
                "Shaanthamaaya manassum samayochithamaaya buddhiyum ethu prathisandhiyum pariharikkum."
            )
            "Jataka Tales" -> StoryMoral(
                "दयालुता और निःस्वार्थ भाव सबसे बड़ा धर्म है।",
                "Dayaaluta aur nihswaarth bhaav sabse bada dharm hai.",
                "ಕರುಣೆ ಮತ್ತು ನಿಸ್ವಾರ್ಥ ಸೇವೆಯೇ ನಿಜವಾದ ಪುಣ್ಯ.",
                "Karune mattu nisvaartha seveye nijaavada punya.",
                "Kindness, selflessness, and compassion are the greatest virtues.",
                "ദയയും നിസ്വാർത്ഥതയുമാണ് ഏറ്റവും വലിയ പുണ്യം.",
                "Dayayum niswaarthathayumaanu ettavum valiya punyam."
            )
            else -> StoryMoral(
                "सच्चाई और एकता में ही सच्ची विजय है।",
                "Sachhaai aur ekta me hi sachhi vijay hai.",
                "ಒಗ್ಗಟ್ಟಿನಲ್ಲಿ ಬಲವಿದೆ ಮತ್ತು ಸತ್ಯವೇ ಶಾಶ್ವತ.",
                "Oggattinalli balavide mattu satyave shaashvata.",
                "Unity is strength, and honest deeds always bring lasting happiness.",
                "ഐക്യമത്യം മഹാബലം, സത്യം എപ്പോഴും നിലനിൽക്കും.",
                "Aikyamathyam mahaabalam, satyam eppozhum nilanilkkum."
            )
        }
    }
}
