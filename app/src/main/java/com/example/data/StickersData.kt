package com.example.data

data class RewardSticker(
    val id: String,
    val title: String,
    val emoji: String,
    val description: String,
    val criteria: String,
    val rarity: String // "Common", "Rare", "Epic", "Legendary"
)

data class UserLevelInfo(
    val levelNumber: Int,
    val levelTitle: String,
    val currentXp: Int,
    val minXp: Int,
    val maxXp: Int,
    val progress: Float
)

object StickersData {

    val allStickers: List<RewardSticker> = listOf(
        RewardSticker("first_step", "First Step Explorer", "🌟", "Started learning CBSE Hindi & Kannada", "Earn your first 50 XP", "Common"),
        RewardSticker("varnamala_explorer", "Akshar Adventurer", "🔤", "Explored the alphabet charts", "Open and practice Alphabets", "Common"),
        RewardSticker("daily_spark", "Daily Spark", "⚡", "Kept the learning flame alive!", "Log in for consecutive days", "Common"),
        RewardSticker("curious_cub", "Curious Cub", "🐻", "Reached Level 2 milestones", "Reach 250 Total XP", "Rare"),
        RewardSticker("word_explorer", "Word Explorer", "🧭", "Mastered 20 vocabulary words", "Reach 500 Total XP", "Rare"),
        RewardSticker("language_champion", "Language Champion", "🏆", "Completed multiple CBSE worksheets", "Reach 1000 Total XP", "Epic"),
        RewardSticker("lingua_guru", "Lingua Guru", "👑", "Achieved highest fluency honor!", "Reach 1500 Total XP", "Legendary"),
        RewardSticker("peacock_scholar", "Peacock Scholar", "🦚", "Practiced Hindi & Kannada pronunciation", "Listen to 10 audio clips", "Rare"),
        RewardSticker("elephant_explorer", "Gaja Master", "🐘", "Learned animal vocabulary in both tongues", "Complete Animals worksheet", "Rare"),
        RewardSticker("story_explorer", "Story Explorer", "📚", "Finished reading your first story!", "Read and finish 1 story", "Common"),
        RewardSticker("bookworm", "Bookworm Supreme", "📖", "Dived deep into traditional folk tales", "Complete 5 stories", "Rare"),
        RewardSticker("story_sage", "Panchatantra Sage", "🦉", "Understood 10 moral stories", "Complete 10 stories", "Epic"),
        RewardSticker("quiz_whiz", "Quiz Whiz", "🎯", "Scored 100% on a CBSE worksheet", "Get full marks on any quiz", "Rare"),
        RewardSticker("super_streak", "Streak Dynamo", "🔥", "Maintained 3+ days study streak", "Keep active for 3 days", "Epic"),
        RewardSticker("trilingual_star", "Trilingual Star", "🌐", "Practiced English, Hindi & Kannada", "Switch language in reader", "Rare"),
        RewardSticker("rainbow_learner", "Rainbow Master", "🌈", "Learned colors in both languages", "Complete Colors worksheet", "Common")
    )

    fun calculateLevel(totalXp: Int): UserLevelInfo {
        return when {
            totalXp < 250 -> UserLevelInfo(1, "Novice Beginner", totalXp, 0, 250, totalXp / 250f)
            totalXp < 500 -> UserLevelInfo(2, "Curious Cub", totalXp, 250, 500, (totalXp - 250) / 250f)
            totalXp < 1000 -> UserLevelInfo(3, "Word Explorer", totalXp, 500, 1000, (totalXp - 500) / 500f)
            totalXp < 1500 -> UserLevelInfo(4, "Language Champion", totalXp, 1000, 1500, (totalXp - 1000) / 500f)
            else -> UserLevelInfo(5, "Lingua Guru", totalXp, 1500, 2500, 1.0f)
        }
    }
}
