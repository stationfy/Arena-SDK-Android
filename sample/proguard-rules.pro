## Live Blog
-keep class im.arena.liveblog.** { *; }
-keep class im.arena.streaming.** { *; }
-keep class im.arena.commons.** { *; }
-keep class im.arena.player.** { *; }
-keep class im.arena.basiccard.** { *; }
-keep class im.arena.profile.** { *; }


## Android
-keep class androidx.appcompat.widget.** { *; }

## Kotlin
-keep class kotlin.jvm.** { *; }
-keep class kotlin.reflect.** { *; }
-keep class kotlin.internal.** { *; }
-keep class kotlin.** { *; }
-dontwarn kotlin.reflect.jvm.**

## Glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.module.AppGlideModule
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
-dontwarn com.bumptech.glide.loa


## OkHttp
-keep class javax.annotation.** { *; }
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase
-dontwarn okhttp3.**
-dontwarn okio.**
-dontwarn javax.annotation.**
-dontwarn org.conscrypt.**
-dontwarn okhttp3.internal.platform.*
-dontnote okhttp3.internal.platform.*
-dontwarn javax.**
-dontwarn lombok.**
-dontwarn org.apache.**

## Retrofit
-keep class com.squareup.** { *; }
-keep interface com.squareup.** { *; }
-keep class retrofit2.** { *; }
-keep interface retrofit2.** { *;}
-keep interface com.squareup.** { *; }
-keepclasseswithmembers class * {
    @retrofit.http.* <methods>;
}
-dontwarn retrofit2.**
-dontnote retrofit2.Platform
-dontnote retrofit2.Platform$IOS$MainThreadExecutor
-dontwarn retrofit2.Platform$Java8


## Gson
-keepattributes Signature
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }

