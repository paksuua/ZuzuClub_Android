package com.stock.sns.zuzuclub_android.data.model

data class Feed(
    var profileImage:String,
    var nickname: String,
    var updated: String, //백에서 들어오는 타입보고 변경
    var emojiType: Int, //일단 없는거 0 여우 1, 사자 2, 토끼 3, 말 4
    var text: String,
    var reaction:Int,
    var comment: Int
)

fun getDefaultFeedList() = arrayListOf(
    Feed(
        profileImage = "http://placehold.it/120x120&text=image1",
        nickname = "방배동 살쾡이",
        updated = "2시간 전",
        emojiType = 3,
        text = "\$카카오 이제 들어간다~! ",
        reaction = 4,
        comment = 12
    ),
    Feed(
        profileImage = "http://placehold.it/120x120&text=image2",
        nickname = "방배동 살쾡이",
        updated = "2시간 전",
        emojiType = 3,
        text = "\$카카오 이제 들어간다~! ",
        reaction = 4,
        comment = 12
    ),
    Feed(
        profileImage = "http://placehold.it/120x120&text=image3",
        nickname = "방배동 살쾡이",
        updated = "2시간 전",
        emojiType = 3,
        text = "\$카카오 이제 들어간다~! ",
        reaction = 4,
        comment = 12
    ),
    Feed(
        profileImage = "http://placehold.it/120x120&text=image4",
        nickname = "방배동 살쾡이",
        updated = "2시간 전",
        emojiType = 3,
        text = "\$카카오 이제 들어간다~! ",
        reaction = 4,
        comment = 12
    ),
    Feed(
        profileImage = "http://placehold.it/120x120&text=image5",
        nickname = "방배동 살쾡이",
        updated = "2시간 전",
        emojiType = 3,
        text = "\$카카오 이제 들어간다~! ",
        reaction = 4,
        comment = 12
    ),
    Feed(
        profileImage = "http://placehold.it/120x120&text=image6",
        nickname = "방배동 살쾡이",
        updated = "2시간 전",
        emojiType = 3,
        text = "\$카카오 이제 들어간다~! ",
        reaction = 4,
        comment = 12
    ),
    Feed(
        profileImage = "http://placehold.it/120x120&text=image7",
        nickname = "방배동 살쾡이",
        updated = "2시간 전",
        emojiType = 3,
        text = "\$카카오 이제 들어간다~! ",
        reaction = 4,
        comment = 12
    ),
    Feed(
        profileImage = "http://placehold.it/120x120&text=image8",
        nickname = "방배동 살쾡이",
        updated = "2시간 전",
        emojiType = 3,
        text = "\$카카오 이제 들어간다~! ",
        reaction = 4,
        comment = 12
    ),
    Feed(
        profileImage = "http://placehold.it/120x120&text=image9",
        nickname = "방배동 살쾡이",
        updated = "2시간 전",
        emojiType = 3,
        text = "\$카카오 이제 들어간다~! ",
        reaction = 4,
        comment = 12
    ),
    Feed(
        profileImage = "http://placehold.it/120x120&text=image10",
        nickname = "방배동 살쾡이",
        updated = "2시간 전",
        emojiType = 3,
        text = "\$카카오 이제 들어간다~! ",
        reaction = 4,
        comment = 12
    )
)