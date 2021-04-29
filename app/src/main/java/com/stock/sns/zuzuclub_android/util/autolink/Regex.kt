package com.stock.sns.zuzuclub_android.util.autolink

import android.util.Patterns
import java.util.regex.Pattern

internal val URL_PATTERN = Pattern.compile("(?:^|\\s|$|[.])@[\\p{L}0-9_]*") // 멘션 @
internal val PHONE_PATTERN: Pattern = Patterns.PHONE
internal val EMAIL_PATTERN: Pattern = Patterns.EMAIL_ADDRESS
internal val MENTION_PATTERN: Pattern = Pattern.compile("\\s\\.\\.\\.더 보기\\b$") // ...더 보기
internal val HASH_TAG_PATTERN: Pattern = Pattern.compile("(?:^|\\s|\$|[.])\\$[\\p{L}0-9_]*") // 종목 태그 $
