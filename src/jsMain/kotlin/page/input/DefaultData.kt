package page.input


internal const val DEFAULT_BEFORE_INPUT =
    """traversal	1s 63ms 213us 570ns	55
androidx.compose.runtime.CompositionLocalProvider (CompositionLocal.kt:225)	767ms 301us 156ns	60
Choreographer#doFrame 11096698	546ms 571us 747ns	1
Compose:recompose	525ms 929us 55ns	27
animation	481ms 187us 128ns	56
layout	457ms 364us 200ns	5
Choreographer#doFrame 11096589	319ms 986us 493ns	1
Recomposer:recompose	314ms 3us 728ns	56
draw	285ms 576us 726ns	55
com.coldstar.compass.stack.PageStack (PageStack.kt:34)	206ms 764us 943ns	8
androidx.compose.ui.layout.LayoutNodeSubcompositionsState.subcompose.<anonymous>.<anonymous>.<anonymous> (SubcomposeLayout.kt:700)	201ms 648us 483ns	18
Record View#draw()	175ms 702us 947ns	55
HWUI:com.android.internal.policy.DecorView	174ms 65us 172ns	55
HWUI:android.widget.LinearLayout	171ms 926us 16ns	55
HWUI:android.widget.FrameLayout	170ms 829us 634ns	55
androidx.compose.runtime.saveable.SaveableStateHolderImpl.SaveableStateProvider (SaveableStateHolder.kt:74)	169ms 921us 92ns	23
HWUI:androidx.compose.ui.platform.ComposeView	169ms 878us 629ns	54
HWUI:androidx.compose.ui.platform.AndroidComposeView	168ms 400us 173ns	52
com.coldstar.compass.stack.StackNavHost (StackNavHost.kt:57)	152ms 976us 92ns	3
androidx.compose.animation.AnimatedEnterExitImpl (AnimatedVisibility.kt:726)	152ms 632us 632ns	10
Recomposer:animation	151ms 923us 396ns	53
activityStart	145ms 560us 707ns	1
androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory.CachedItemContent.createContentLambda.<anonymous> (LazyLayoutItemContentFactory.kt:90)	138ms 189us 707ns	13
androidx.compose.foundation.lazy.layout.SkippableItem (LazyLayoutItemContentFactory.kt:127)	127ms 863us 320ns	13
androidx.compose.foundation.lazy.layout.LazySaveableStateHolder.SaveableStateProvider (LazySaveableStateHolder.kt:82)	124ms 711us 9ns	13
AndroidOwner:measureAndLayout	120ms 530us 89ns	47
Choreographer#doFrame 11096598	115ms 801us 166ns	1
androidx.compose.foundation.lazy.layout.SkippableItem.<anonymous> (LazyLayoutItemContentFactory.kt:133)	102ms 365us 163ns	13
androidx.compose.foundation.lazy.LazyListItemProviderImpl.Item (LazyListItemProvider.kt:75)	101ms 556us 316ns	13
androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItem (LazyLayoutPinnableItem.kt:43)	98ms 812us 240ns	13
Compose:applyChanges	97ms 913us 472ns	27
com.coldstar.compass.stack.PageStack.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PageStack.kt:99)	89ms 137us 317ns	10
com.coldstar.compass.stack.PageStack.<anonymous>.<anonymous>.<anonymous>.LayerContent (PageStack.kt:56)	88ms 496us 623ns	10
androidx.compose.ui.platform.WrappedComposition.setContent.<anonymous>.<anonymous> (Wrapper.android.kt:141)	88ms 251us 163ns	1
com.coldstar.compass.stack.Render (StackGraph.kt:167)	85ms 434us 313ns	10
androidx.compose.ui.platform.WrappedComposition.setContent.<anonymous>.<anonymous>.<anonymous> (Wrapper.android.kt:156)	83ms 552us 624ns	1
androidx.compose.ui.platform.ProvideAndroidCompositionLocals (AndroidCompositionLocals.android.kt:80)	82ms 816us 547ns	1
com.coldstar.compass.LocalOwnersProvider (NavEntry.kt:144)	79ms 435us 698ns	10
androidx.compose.foundation.lazy.LazyListItemProviderImpl.Item.<anonymous> (LazyListItemProvider.kt:76)	79ms 127us 701ns	13
androidx.compose.ui.platform.ProvideAndroidCompositionLocals.<anonymous> (AndroidCompositionLocals.android.kt:117)	76ms 460us 239ns	1
androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:600)	76ms 362us 700ns	2
androidx.compose.foundation.lazy.LazyListIntervalContent.item.<anonymous> (LazyListIntervalContent.kt:58)	76ms 282us 853ns	13
androidx.compose.ui.platform.ProvideCommonCompositionLocals (CompositionLocals.kt:189)	74ms 433us 777ns	1
com.coldstar.compass_sample.SampleItem (SampleSelectorUi.kt:141)	72ms 852us 160ns	13
androidx.compose.material.Surface (Surface.kt:104)	72ms 352us 622ns	3
androidx.compose.ui.platform.AbstractComposeView.ensureCompositionCreated.<anonymous> (ComposeView.android.kt:250)	70ms 734us 161ns	1
androidx.compose.ui.platform.ComposeView.Content (ComposeView.android.kt:426)	70ms 383us 161ns	1
com.coldstar.compass_sample.ComposableSingletons.MainActivityKt.lambda-3.<anonymous> (MainActivity.kt:21)	70ms 55us 161ns	1
com.coldstar.compass_sample.ui.theme.CompassSampleTheme (Theme.kt:18)	69ms 159us 315ns	1
androidx.compose.material.Text (Text.kt:92)	69ms 137us 394ns	15
binder transaction	68ms 859us 547ns	42
performCreate:com.coldstar.compass_sample.MainActivity	67ms 313us 853ns	1
androidx.compose.material.Surface.<anonymous> (Surface.kt:117)	67ms 274us 699ns	3
androidx.compose.material.MaterialTheme (MaterialTheme.kt:58)	62ms 714us 468ns	1
com.coldstar.compass.LocalOwnersProvider.<anonymous> (NavEntry.kt:151)	61ms 634us 392ns	10
androidx.compose.foundation.text.BasicText (BasicText.kt:79)	61ms 158us 466ns	15
com.coldstar.compass.SaveableStateProvider (NavEntry.kt:156)	59ms 980us 546ns	10
androidx.compose.material.ProvideTextStyle (Text.kt:393)	54ms 850us 851ns	2
androidx.compose.material.MaterialTheme.<anonymous> (MaterialTheme.kt:79)	51ms 597us 851ns	1
androidx.compose.material.MaterialTheme.<anonymous>.<anonymous> (MaterialTheme.kt:80)	48ms 310us 851ns	1
androidx.compose.material.PlatformMaterialTheme (MaterialTheme.android.kt:21)	47ms 958us 390ns	1
com.coldstar.compass_sample.ComposableSingletons.MainActivityKt.lambda-2.<anonymous> (MainActivity.kt:23)	47ms 788us 928ns	1
measure	42ms 795us 850ns	6
androidx.compose.foundation.indication.<anonymous> (Indication.kt:107)	40ms 640us 544ns	13
androidx.compose.material.ripple.Ripple.rememberUpdatedInstance (Ripple.kt:113)	38ms 652us 543ns	13
com.coldstar.compass_sample.ComposableSingletons.MainActivityKt.lambda-1.<anonymous> (MainActivity.kt:26)	37ms 476us 312ns	1
com.coldstar.compass_sample.App (AppUI.kt:41)	37ms 261us 542ns	1
AndroidOwner:onMeasure	36ms 925us 696ns	6
com.coldstar.compass.stack.Render.<anonymous> (StackGraph.kt:185)	35ms 144us 927ns	10
Choreographer#doFrame 11096758	34ms 427us 157ns	1
Choreographer#doFrame 11096691	32ms 899us 388ns	1
androidx.compose.material.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:319)	30ms 873us 619ns	1
com.coldstar.compass_sample.SampleSelectorUi.<anonymous> (SampleSelectorUi.kt:30)	30ms 695us 157ns	1
androidx.compose.runtime.ComposerImpl.startProviders.<anonymous> (Composer.kt:1994)	30ms 389us 310ns	60
Choreographer#doFrame 11096700	30ms 44us 3ns	1
activityResume	27ms 76us 2ns	1
androidx.compose.runtime.compositionLocalMapOf (CompositionLocalMap.kt:91)	26ms 697us 229ns	60
androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:345)	24ms 773us 464ns	1
androidx.compose.foundation.lazy.LazyList (LazyList.kt:50)	24ms 483us 310ns	1
Choreographer#doFrame 11096649	23ms 601us 233ns	1
Choreographer#doFrame 11096613	23ms 456us 925ns	1
Choreographer#doFrame 11096637	22ms 705us 2ns	1
com.coldstar.compass_sample.App.<anonymous>.<anonymous> (AppUI.kt:55)	21ms 943us 387ns	1
com.coldstar.compass_sample.ComposableSingletons.SampleSelectorUiKt.lambda-2.<anonymous> (SampleSelectorUi.kt:24)	21ms 678us 79ns	1
com.coldstar.compass_sample.SampleSelectorUi (SampleSelectorUi.kt:19)	21ms 329us 463ns	1
androidx.compose.ui.layout.materializerOf.<anonymous> (Layout.kt:201)	19ms 142us 81ns	27
androidx.compose.material.TopAppBar (AppBar.kt:76)	18ms 590us 848ns	1
Compose:onRemembered	18ms 409us 847ns	18
androidx.compose.material.AppBar (AppBar.kt:504)	18ms 220us 617ns	1
Choreographer#doFrame 11096669	17ms 898us 771ns	1
Choreographer#doFrame 11096655	17ms 509us 925ns	1
Choreographer#doFrame 11096640	17ms 155us 310ns	1
Choreographer#doFrame 11096658	16ms 958us 463ns	1
relayoutWindow	15ms 521us 156ns	1
androidx.compose.runtime.saveable.rememberSaveable (RememberSaveable.kt:65)	15ms 29us 385ns	12
androidx.compose.material.ripple.PlatformRipple.rememberUpdatedRippleInstance (Ripple.android.kt:57)	14ms 420us 78ns	13
androidx.compose.material.AppBar.<anonymous> (AppBar.kt:519)	13ms 764us 78ns	1
Choreographer#doFrame 11096693	12ms 856us 924ns	1
androidx.compose.animation.core.updateTransition (Transition.kt:67)	12ms 537us 3ns	8
Choreographer#doFrame 11096646	12ms 463us 385ns	1
androidx.compose.animation.createModifier (EnterExitTransition.kt:819)	12ms 282us 771ns	10
androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:52)	12ms 93us 155ns	1
androidx.compose.material.AppBar.<anonymous>.<anonymous> (AppBar.kt:520)	12ms 86us 155ns	1
Choreographer#doFrame 11096710	11ms 826us 155ns	1
androidx.compose.foundation.lazy.layout.LazySaveableStateHolderProvider (LazySaveableStateHolder.kt:41)	11ms 648us 616ns	1
Choreographer#doFrame 11096671	11ms 599us 155ns	1
androidx.compose.runtime.saveable.rememberSaveableStateHolder (SaveableStateHolder.kt:58)	10ms 758us 924ns	9
Choreographer#doFrame 11096652	10ms 229us 155ns	1
androidx.compose.material.Scaffold (Scaffold.kt:158)	9ms 963us 308ns	1
com.coldstar.compass_sample.SampleSelectorUi.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SampleSelectorUi.kt:34)	9ms 953us 847ns	1
androidx.compose.runtime.rememberUpdatedState (SnapshotState.kt:303)	9ms 732us 546ns	99
androidx.compose.animation.slideInOut.<anonymous> (EnterExitTransition.kt:949)	9ms 473us 616ns	10
Choreographer#doFrame 11096631	9ms 447us 693ns	1
androidx.compose.foundation.lazy.layout.LazySaveableStateHolderProvider.<anonymous> (LazySaveableStateHolder.kt:48)	9ms 244us 924ns	1
Choreographer#doFrame 11096706	9ms 219us 77ns	1
androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:178)	9ms 210us 770ns	1
Choreographer#scheduleVsyncLocked	9ms 87us 850ns	59
androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:254)	8ms 968us 77ns	2
Choreographer#doFrame 11096740	8ms 954us 847ns	1
com.coldstar.compass_sample.ComposableSingletons.AppUIKt.lambda-1.<anonymous> (AppUI.kt:50)	8ms 936us 616ns	1
androidx.compose.material.TopAppBar.<anonymous> (AppBar.kt:92)	8ms 929us 462ns	1
Choreographer#doFrame 11096746	8ms 572us 924ns	1
Choreographer#doFrame 11096750	8ms 517us 231ns	1
androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:310)	8ms 481us 539ns	2
Choreographer#doFrame 11096742	8ms 478us 154ns	1
MSG_INSETS_CONTROL_CHANGED	8ms 354us 693ns	2
com.coldstar.compass_sample.SplashPageUI (SplashUI.kt:14)	8ms 317us 462ns	1
Choreographer#doFrame 11096734	8ms 292us 924ns	1
androidx.compose.foundation.lazy.layout.LazyLayout.<anonymous> (LazyLayout.kt:60)	8ms 246us 232ns	1
androidx.compose.animation.core.createChildTransitionInternal (Transition.kt:794)	8ms 170us 691ns	10
com.coldstar.compass_sample.SampleSelectorUi.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SampleSelectorUi.kt:110)	8ms 143us 309ns	1
Choreographer#doFrame 11096732	8ms 97us 616ns	1
Choreographer#doFrame 11096744	7ms 930us 693ns	1
androidx.compose.runtime.DisposableEffect (Effects.kt:151)	7ms 868us 766ns	110
Choreographer#doFrame 11096718	7ms 585us 847ns	1
Choreographer#doFrame 11096748	7ms 523us 385ns	1
Choreographer#doFrame 11096756	7ms 505us 924ns	1
androidx.compose.animation.core.Transition.animateTo (Transition.kt:425)	7ms 485us 924ns	8
Choreographer#doFrame 11096736	7ms 397us 462ns	1
Choreographer#doFrame 11096673	7ms 343us 693ns	1
Choreographer#doFrame 11096738	7ms 329us 154ns	1
Choreographer#doFrame 11096714	7ms 311us 78ns	1
com.coldstar.compass_sample.SampleSelectorUi.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SampleSelectorUi.kt:62)	7ms 218us 462ns	1
Choreographer#doFrame 11096712	7ms 197us 1ns	1
Choreographer#doFrame 11096726	6ms 871us 77ns	1
Choreographer#doFrame 11096720	6ms 862us 693ns	1
Choreographer#doFrame 11096716	6ms 785us 923ns	1
Choreographer#doFrame 11096661	6ms 783us 155ns	1
Choreographer#doFrame 11096730	6ms 781us 1ns	1
androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:739)	6ms 668us 846ns	20
Choreographer#doFrame 11096722	6ms 667us 693ns	1
Choreographer#doFrame 11096752	6ms 650us 770ns	1
Choreographer#doFrame 11096728	6ms 615us 1ns	1
Choreographer#doFrame 11096724	6ms 421us 616ns	1
com.coldstar.compass_sample.SampleSelectorUi.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SampleSelectorUi.kt:54)	6ms 411us 693ns	1
Lock contention on InternTable lock (owner tid: 27296)	6ms 12us 847ns	3
Choreographer#doFrame 11096663	5ms 868us	1
Choreographer#doFrame 11096689	5ms 833us 539ns	1
Choreographer#doFrame 11096675	5ms 739us 769ns	1
Lock contention on ClassLinker classes lock (owner tid: 27296)	5ms 654us	3
androidx.compose.material.MaterialRippleTheme.defaultColor (MaterialTheme.kt:127)	5ms 646us	13
Choreographer#doFrame 11096665	5ms 644us 924ns	1
com.coldstar.compass_sample.SampleSelectorUi.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SampleSelectorUi.kt:118)	5ms 585us 847ns	1
Choreographer#doFrame 11096667	5ms 354us 847ns	1
com.coldstar.compass_sample.SampleSelectorUi.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SampleSelectorUi.kt:46)	5ms 296us 232ns	1
androidx.compose.animation.targetEnterExit (AnimatedVisibility.kt:830)	5ms 282us 542ns	20
Choreographer#doFrame 11096677	4ms 929us 462ns	1
Choreographer#doFrame 11096679	4ms 924us 385ns	1
Choreographer#doFrame 11096685	4ms 906us 770ns	1
ResourcesManager#getResources	4ms 824us 462ns	3
com.coldstar.compass_sample.SampleSelectorUi.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SampleSelectorUi.kt:70)	4ms 819us 78ns	1
androidx.compose.foundation.gestures.scrollable.<anonymous> (Scrollable.kt:161)	4ms 809us 923ns	1
Choreographer#doFrame 11096683	4ms 752us 539ns	1
com.coldstar.compass_sample.SampleSelectorUi.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SampleSelectorUi.kt:86)	4ms 732us 231ns	1
Choreographer#doFrame 11096681	4ms 723us 693ns	1
com.coldstar.compass_sample.SampleSelectorUi.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SampleSelectorUi.kt:78)	4ms 677us 309ns	1
androidx.compose.runtime.DynamicProvidableCompositionLocal.provided (CompositionLocal.kt:125)	4ms 665us 308ns	47
androidx.compose.animation.core.Transition.updateTarget (Transition.kt:400)	4ms 620us 614ns	14
com.coldstar.compass_sample.SampleSelectorUi.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SampleSelectorUi.kt:102)	4ms 496us 693ns	1
com.coldstar.compass_sample.SampleSelectorUi.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SampleSelectorUi.kt:94)	4ms 483us 924ns	1
Choreographer#doFrame 11096754	4ms 459us 693ns	1
com.coldstar.compass_sample.SampleSelectorUi.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SampleSelectorUi.kt:38)	4ms 304us 616ns	1
com.coldstar.compass_sample.SampleSelectorUi.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SampleSelectorUi.kt:126)	4ms 246us 769ns	1
ResourcesManager#createBaseActivityResources	4ms 190us 462ns	1
ResourcesImpl#updateConfiguration	4ms	2
androidx.compose.material.Scaffold.<anonymous>.<anonymous> (Scaffold.kt:179)	3ms 976us	1
androidx.compose.foundation.lazy.rememberLazyListState (LazyListState.kt:57)	3ms 729us 847ns	1
androidx.compose.material.MaterialTheme.<get-colors> (MaterialTheme.kt:102)	3ms 696us 774ns	47
androidx.compose.foundation.lazy.ScrollPositionUpdater (LazyList.kt:140)	3ms 653us 154ns	1
androidx.compose.material.rememberDrawerState (Drawer.kt:451)	3ms 644us 77ns	1
androidx.compose.foundation.clickable.<anonymous> (Clickable.kt:97)	3ms 578us 998ns	13
VerifyClass androidx.compose.runtime.snapshots.SnapshotStateList	3ms 556us	1
androidx.compose.material.ScaffoldLayout (Scaffold.kt:227)	3ms 538us 692ns	1
androidx.compose.runtime.LaunchedEffect (Effects.kt:333)	3ms 363us	28
AssetManager::SetApkAssets	3ms 312us 693ns	2
androidx.compose.foundation.gestures.ScrollableDefaults.overscrollEffect (Scrollable.kt:206)	3ms 294us 770ns	1
androidx.compose.runtime.LaunchedEffect (Effects.kt:355)	3ms 292us 538ns	13
androidx.compose.material.ContentAlpha.contentAlpha (ContentAlpha.kt:70)	3ms 200us 78ns	5
androidx.compose.material.MaterialRippleTheme.rippleAlpha (MaterialTheme.kt:133)	3ms 177us 462ns	13
androidx.compose.material.rememberTextSelectionColors (MaterialTextSelectionColors.kt:35)	3ms 149us 462ns	1
MSG_WINDOW_FOCUS_CHANGED	3ms 111us 693ns	1
androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:72)	3ms 99us 769ns	1
androidx.compose.material.Scaffold.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:185)	3ms 99us 385ns	1
com.coldstar.compass.getNavController (NavController.kt:15)	3ms 60us 538ns	2
TextLayout:initLayout	2ms 972us 541ns	16
androidx.compose.material.ComposableSingletons.ScaffoldKt.lambda-3.<anonymous> (Scaffold.kt:163)	2ms 921us 231ns	1
androidx.compose.foundation.rememberOverscrollEffect (AndroidOverscroll.kt:62)	2ms 823us 385ns	1
androidx.compose.animation.core.createDeferredAnimation (Transition.kt:749)	2ms 800us 231ns	6
androidx.compose.material.ContentAlpha.<get-medium> (ContentAlpha.kt:45)	2ms 776us	3
androidx.compose.material.TopAppBar.<anonymous>.<anonymous>.<anonymous> (AppBar.kt:108)	2ms 584us 385ns	1
Choreographer#doFrame 11096687	2ms 491us 77ns	1
inflate	2ms 430us 462ns	1
VerifyClass androidx.compose.runtime.snapshots.SnapshotStateMap	2ms 326us 385ns	1
Compose:onForgotten	2ms 315us 462ns	2
androidx.compose.material.SnackbarHost (SnackbarHost.kt:150)	2ms 305us 847ns	1
androidx.compose.foundation.gestures.pointerScrollable (Scrollable.kt:247)	2ms 197us	1
androidx.compose.material.surfaceColorAtElevation (Surface.kt:630)	2ms 170us 153ns	3
com.coldstar.compass.core.rememberRootNavController (RootNavController.kt:28)	2ms 125us 538ns	1
androidx.compose.animation.shrinkExpand.<anonymous> (EnterExitTransition.kt:1030)	2ms 41us 307ns	10
androidx.compose.material.contentColorFor (Colors.kt:295)	1ms 957us	5
androidx.compose.runtime.StaticProvidableCompositionLocal.provided (CompositionLocal.kt:139)	1ms 582us 387ns	75
AssetManager::GetResourceLocales	1ms 388us 999ns	3
androidx.compose.runtime.<get-currentCompositeKeyHash> (Composables.kt:224)	1ms 385us 694ns	83
Theme::ApplyStyle	1ms 384us 617ns	7
androidx.compose.foundation.gestures.ScrollableDefaults.flingBehavior (Scrollable.kt:193)	1ms 344us	1
com.coldstar.compass_sample.ComposableSingletons.SampleSelectorUiKt.lambda-1.<anonymous> (SampleSelectorUi.kt:25)	1ms 342us 539ns	1
androidx.compose.material.ripple.rememberRipple (Ripple.kt:76)	1ms 329us 231ns	1
androidx.compose.foundation.lazy.rememberLazyListItemProviderLambda (LazyListItemProvider.kt:40)	1ms 328us 77ns	1
AssetManager::SetConfiguration	1ms 321us 154ns	2
onCreateView:ViewStub	1ms 307us 769ns	1
androidx.compose.runtime.DisposableEffect (Effects.kt:190)	1ms 237us 614ns	16
ViewStub	1ms 211us 615ns	4
androidx.compose.foundation.lazy.layout.lazyLayoutSemantics (LazyLayoutSemantics.kt:40)	1ms 194us 154ns	1
androidx.compose.runtime.rememberCompositionContext (Composables.kt:480)	1ms 156us 923ns	2
androidx.compose.material.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:288)	1ms 88us 385ns	1
androidx.compose.material.DefaultElevationOverlay.apply (ElevationOverlay.kt:68)	1ms 87us 769ns	3
androidx.compose.material.FadeInFadeOutWithScale (SnackbarHost.kt:256)	1ms 71us	1
androidx.compose.material.ripple.PlatformRipple.findNearestViewGroup (Ripple.android.kt:104)	1ms 12us 154ns	13
Lock contention on Class loader classes (owner tid: 18446744073709551615)	1ms 1us 847ns	2
EmojiCompat.EmojiCompatInitializer.run	935us 385ns	1
androidx.compose.material.TopAppBar.<anonymous>.<anonymous> (AppBar.kt:116)	924us 538ns	1
performResume:com.coldstar.compass_sample.MainActivity	909us	1
androidx.compose.foundation.lazy.layout.LazyLayoutPrefetcher (LazyLayoutPrefetcher.android.kt:35)	885us 539ns	1
androidx.compose.material.ContentAlpha.<get-high> (ContentAlpha.kt:34)	880us 924ns	2
Compose:sideeffects	837us 768ns	7
FullSuspendCheck	820us 770ns	3
androidx.compose.ui.platform.obtainImageVectorCache (AndroidCompositionLocals.android.kt:128)	809us 154ns	1
androidx.compose.foundation.layout.rememberBoxMeasurePolicy (Box.kt:79)	738us 155ns	13
Run checkpoint function	715us 459ns	18
androidx.compose.animation.rememberSplineBasedDecay (SplineBasedFloatDecayAnimationSpec.android.kt:40)	600us 385ns	1
androidx.compose.foundation.layout.Spacer (Spacer.kt:38)	589us 230ns	1
androidx.compose.foundation.lazy.lazyListBeyondBoundsModifier (LazyListBeyondBoundsModifier.kt:32)	568us 308ns	1
reportFullyDrawn() for ComponentActivity	546us 770ns	1
ResourcesManager#createApkAssetsSupplierNotLocked	503us 616ns	3
dispatchApplyInsets	452us 923ns	1
onCreateView:LinearLayout	425us 307ns	1
Loading font /data/fonts/files/~~iDyw0kIIl0CBiUefuOtFyA==/NotoColorEmoji.ttf	413us 231ns	1
androidx.compose.runtime.SideEffect (Effects.kt:45)	408us 307ns	9
androidx.compose.foundation.layout.rowMeasurePolicy (Row.kt:100)	406us 77ns	3
LinearLayout	398us 385ns	1
androidx.compose.material.DrawerDefaults.<get-scrimColor> (Drawer.kt:787)	395us 615ns	1
Loading font /system/fonts/RobotoStatic-Regular.ttf	376us 230ns	1
androidx.compose.material.calculateForegroundColor (ElevationOverlay.kt:86)	360us 539ns	1
AssetManager::OpenXmlAsset(res/layout/screen_simple.xml)	328us 616ns	1
onCreateView:FrameLayout	326us 154ns	1
FrameLayout	311us 307ns	1
androidx.compose.runtime.DisposableEffect (Effects.kt:230)	305us 922ns	3
AssetManager::OpenXmlAsset(res/interpolator/linear_out_slow_in.xml)	287us 154ns	1
reportFullyDrawn() for {com.coldstar.compass_sample/com.coldstar.compass_sample.MainActivity}	280us 615ns	1
Loading font /system/fonts/Roboto-Regular.ttf	266us 77ns	1
Choreographer#onVsync 11096728	245us 847ns	1
AssetManager::OpenXmlAsset(res/transition/fade.xml)	234us 846ns	1
AssetManager::OpenXmlAsset(res/transition/move.xml)	232us 77ns	1
AssetManager::OpenXmlAsset(res/interpolator/fast_out_linear_in.xml)	211us 615ns	1
androidx.compose.foundation.lazy.rememberLazyListSemanticState (LazyListSemantics.kt:23)	201us 154ns	1
Choreographer#onVsync 11096748	200us	1
Choreographer#onVsync 11096744	197us 231ns	1
Choreographer#onVsync 11096740	197us 231ns	1
Choreographer#onVsync 11096752	194us 462ns	1
Choreographer#onVsync 11096734	192us	1
Choreographer#onVsync 11096742	191us 692ns	1
Choreographer#onVsync 11096730	191us 308ns	1
providerRemove	191us 77ns	1
androidx.compose.material.rememberScaffoldState (Scaffold.kt:62)	189us 846ns	1
Choreographer#onVsync 11096738	186us 77ns	1
topResumedActivityChangeItem	182us 769ns	1
Choreographer#onVsync 11096754	180us 538ns	1
HWUI:android.view.View	179us 76ns	2
Choreographer#onVsync 11096746	176us 384ns	1
connect	176us 308ns	1
Choreographer#onVsync 11096758	176us 307ns	1
Choreographer#onVsync 11096736	173us 846ns	1
Choreographer#onVsync 11096756	173us 769ns	1
Choreographer#onVsync 11096750	167us 770ns	1
Choreographer#onVsync 11096696	164us 615ns	1
hintActivityLaunch	163us 77ns	1
Compose:unobserve	162us 154ns	1
Choreographer#onVsync 11096698	161us 616ns	1
Lock contention on a monitor lock (owner tid: 27484)	160us 847ns	2
Choreographer#onVsync 11096677	160us 308ns	1
Choreographer#onVsync 11096685	154us 462ns	1
Compose:releases	153us 231ns	1
Choreographer#onVsync 11096714	153us 231ns	1
Choreographer#onVsync 11096631	152us 231ns	1
finish draw	151us 154ns	1
androidx.compose.foundation.lazy.rememberLazyListMeasurePolicy (LazyList.kt:152)	150us 462ns	1
Choreographer#onVsync 11096661	144us	1
Choreographer#onVsync 11096691	142us 769ns	1
Choreographer#onVsync 11096764	142us 462ns	1
Choreographer#onVsync 11096712	139us 308ns	1
Choreographer#onVsync 11096732	136us 846ns	1
Choreographer#onVsync 11096720	136us 692ns	1
Choreographer#onVsync 11096718	135us 923ns	1
Choreographer#onVsync 11096689	134us 77ns	1
Choreographer#onVsync 11096710	132us 385ns	1
androidx.compose.material.MaterialTheme.<get-shapes> (MaterialTheme.kt:120)	130us 461ns	1
Choreographer#onVsync 11096722	129us 231ns	1
Choreographer#onVsync 11096681	128us 923ns	1
Choreographer#onVsync 11096669	128us 923ns	1
Choreographer#onVsync 11096724	128us 615ns	1
Choreographer#onVsync 11096683	128us 615ns	1
Choreographer#onVsync 11096716	128us 230ns	1
Choreographer#onVsync 11096687	127us 693ns	1
Choreographer#onVsync 11096726	127us 692ns	1
Choreographer#onVsync 11096667	127us 461ns	1
Choreographer#onVsync 11096679	126us 692ns	1
Choreographer#onVsync 11096665	125us 846ns	1
Choreographer#onVsync 11096663	124us 616ns	1
monitor contention with owner kotlinx.coroutines.DefaultExecutor (21) at boolean android.os.MessageQueue.enqueueMessage(android.os.Message, long)(MessageQueue.java:554) waiters=0 blocking from android.os.Message android.os.MessageQueue.next()(MessageQueue.java:337)	122us 77ns	1
Choreographer#onVsync 11096675	118us 461ns	1
AssetManager::GetResourceConfigurations	116us 846ns	1
Choreographer#onVsync 11096589	113us 846ns	1
Choreographer#onVsync 11096673	113us	1
monitor contention with owner kotlinx.coroutines.DefaultExecutor (21) at void android.view.Choreographer.postFrameCallback(android.view.Choreographer.FrameCallback)(Choreographer.java:560) waiters=0 blocking from java.lang.Runnable androidx.compose.ui.platform.AndroidUiDispatcher.nextTask()(AndroidUiDispatcher.android.kt:192)	110us 769ns	1
virtual void art::jit::MarkCodeClosure::Run(art::Thread *)	95us 462ns	1
androidx.compose.foundation.gestures.platformScrollConfig (AndroidScrollable.android.kt:27)	93us 461ns	1
monitor contention with owner Binder:27282_3 (16) at void android.os.MessageQueue.nativeWake(long)(MessageQueue.java:-2) waiters=0 blocking from android.os.Message android.os.MessageQueue.next()(MessageQueue.java:337)	92us 923ns	1
Choreographer#onVsync 11096693	88us 231ns	1
androidx.compose.material.MaterialTheme.<get-typography> (MaterialTheme.kt:112)	85us 770ns	1
Choreographer#onVsync 11096649	82us 231ns	1
Choreographer#onVsync 11096640	78us 154ns	1
Lock contention on a monitor lock (owner tid: 27302)	74us 462ns	1
Choreographer#onVsync 11096700	69us 154ns	1
Choreographer#onVsync 11096655	66us 77ns	1
Choreographer#onVsync 11096658	63us 692ns	1
Choreographer#onVsync 11096652	62us 847ns	1
Choreographer#onVsync 11096613	60us 846ns	1
Choreographer#onVsync 11096671	59us 923ns	1
Choreographer#onVsync 11096706	57us	1
Choreographer#onVsync 11096637	55us 616ns	1
Choreographer#onVsync 11096646	52us 923ns	1
notifyContentCapture(START) for {com.coldstar.compass_sample/com.coldstar.compass_sample.MainActivity}	52us 539ns	1
Choreographer#onVsync 11096760	51us 307ns	1
Lock contention on thread suspend count lock (owner tid: 27296)	44us 847ns	6
Choreographer#onVsync 11096598	44us 846ns	1
open	26us 78ns	3
SuspendThreadByThreadId suspended kotlinx.coroutines.DefaultExecutor id=21	25us 923ns	1
Choreographer#doFrame 11096696	25us 538ns	1
Lock contention on thread suspend count lock (owner tid: 27487)	24us 924ns	2
setMaxAcquiredBufferCount	23us 77ns	2
ResourcesManager#updateResourcesForActivity	22us 154ns	1
Choreographer#doFrame 11096764	21us 538ns	1
androidx.compose.material.ComposableSingletons.ScaffoldKt.lambda-4.<anonymous> (Scaffold.kt:164)	20us 923ns	1
notifyContentCapture(RESUME) for {com.coldstar.compass_sample/com.coldstar.compass_sample.MainActivity}	20us 77ns	1
SuspendThreadByThreadId suspended Binder:27282_3 id=16	18us 77ns	1
androidx.compose.material.ComposableSingletons.ScaffoldKt.lambda-2.<anonymous> (Scaffold.kt:162)	16us 616ns	1
setMaxDequeuedBufferCount	14us 154ns	1
createView by com.coldstar.compass_sample.MainActivity@313f961-LinearLayout	13us 847ns	1
androidx.compose.runtime.<get-currentRecomposeScope> (Composables.kt:192)	13us 770ns	1
dispatchContentCapture() for ViewRootImpl	13us	1
setConsumerName	12us 77ns	2
Lock contention on ClassLinker classes lock (owner tid: 18446744073709551615)	11us 77ns	1
ResourcesManager#applyConfigurationToResources	9us 308ns	2
MSG_CHECK_FOCUS	8us 692ns	1
androidx.compose.material.ComposableSingletons.AppBarKt.lambda-1.<anonymous> (AppBar.kt:80)	8us 615ns	1
waitWhileAllocatingLocked	8us 384ns	3
Lock contention on thread suspend count lock (owner tid: 0)	8us 307ns	1
Lock contention on ClassLinker classes lock (owner tid: 27487)	7us 154ns	1
Lock contention on InternTable lock (owner tid: 27295)	6us 846ns	1
createView by com.coldstar.compass_sample.MainActivity@313f961-FrameLayout	6us 693ns	1
createView by com.coldstar.compass_sample.MainActivity@313f961-ViewStub	6us 462ns	1
Lock contention on thread suspend count lock (owner tid: 27295)	6us 77ns	1
Lock contention on concurrent copying mark stack lock (owner tid: 27296)	5us 847ns	1
setDequeueTimeout	5us 846ns	1
flushContentCapture for ViewRootImpl	5us 769ns	1
setDefaultBufferSize	3us 77ns	1
setConsumerUsageBits	3us 77ns	1
setTransformHint	2us 769ns	1
setDefaultBufferFormat	2us 769ns	1
binder transaction async	0s	70
Choreographer#doFrame 11096760	0s	1"""

internal const val DEFAULT_AFTER_INPUT =
    """androidx.compose.runtime.CompositionLocalProvider (CompositionLocal.kt:225)	6s 702ms 114us 443ns	60
traversal	4s 224ms 663us 576ns	53
Choreographer#doFrame 11095065	3s 679ms 510us 214ns	1
Compose:recompose	3s 644ms 296us 600ns	40
layout	3s 497ms 793us 889ns	5
androidx.compose.ui.layout.LayoutNodeSubcompositionsState.subcompose.<anonymous>.<anonymous>.<anonymous> (SubcomposeLayout.kt:700)	3s 176ms 821us 11ns	18
androidx.compose.runtime.saveable.SaveableStateHolderImpl.SaveableStateProvider (SaveableStateHolder.kt:74)	3s 145ms 5us 850ns	23
androidx.compose.foundation.lazy.layout.LazyLayoutItemContentFactory.CachedItemContent.createContentLambda.<anonymous> (LazyLayoutItemContentFactory.kt:90)	3s 107ms 427us 468ns	13
androidx.compose.foundation.lazy.layout.SkippableItem (LazyLayoutItemContentFactory.kt:127)	3s 97ms 956us 385ns	13
androidx.compose.foundation.lazy.layout.LazySaveableStateHolder.SaveableStateProvider (LazySaveableStateHolder.kt:82)	3s 95ms 77us 697ns	13
androidx.compose.foundation.lazy.layout.SkippableItem.<anonymous> (LazyLayoutItemContentFactory.kt:133)	3s 74ms 342us 309ns	13
androidx.compose.foundation.lazy.LazyListItemProviderImpl.Item (LazyListItemProvider.kt:75)	3s 72ms 880us 617ns	13
androidx.compose.foundation.lazy.layout.LazyLayoutPinnableItem (LazyLayoutPinnableItem.kt:43)	3s 71ms 6us 308ns	13
androidx.compose.foundation.lazy.LazyListItemProviderImpl.Item.<anonymous> (LazyListItemProvider.kt:76)	3s 50ms 258us 149ns	13
androidx.compose.foundation.lazy.LazyListIntervalContent.item.<anonymous> (LazyListIntervalContent.kt:58)	3s 48ms 175us 382ns	13
com.coldstar.compass_sample.SampleItem (SampleSelectorUi.kt:164)	3s 44ms 575us 228ns	13
com.coldstar.compass_sample.BadComposable (SampleSelectorUi.kt:143)	2s 968ms 374us 373ns	13
com.coldstar.compass_sample.performComplexCalculation (SampleSelectorUi.kt:153)	2s 613ms 862us 260ns	13
activityStart	1s 145ms 414us 577ns	1
performCreate:com.coldstar.compass_sample.MainActivity	1s 66ms 181us 569ns	1
initAnotherBadSdk	700ms 938us 455ns	1
animation	495ms 47us 666ns	54
draw	429ms 56us 431ns	53
androidx.compose.ui.res.painterResource (PainterResources.android.kt:56)	336ms 278us 108ns	13
Recomposer:recompose	327ms 969us 960ns	54
com.coldstar.compass_sample.SampleSelectorUi.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SampleSelectorUi.kt:40)	298ms 992us 568ns	1
Choreographer#doFrame 11094962	294ms 540us 953ns	1
Record View#draw()	282ms 627us 416ns	53
HWUI:com.android.internal.policy.DecorView	280ms 979us 799ns	53
HWUI:android.widget.LinearLayout	278ms 611us 259ns	53
HWUI:android.widget.FrameLayout	276ms 616us 491ns	53
HWUI:androidx.compose.ui.platform.ComposeView	275ms 466us 258ns	52
HWUI:androidx.compose.ui.platform.AndroidComposeView	274ms 254us 795ns	50
androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:157)	269ms 725us 872ns	13
androidx.compose.ui.graphics.vector.rememberVectorPainter (VectorPainter.kt:115)	267ms 807us 180ns	13
androidx.compose.ui.graphics.vector.VectorPainter.RenderVector (VectorPainter.kt:221)	256ms 816us 486ns	13
com.coldstar.compass_sample.SampleSelectorUi.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SampleSelectorUi.kt:44)	234ms 761us 562ns	1
com.coldstar.compass_sample.SampleSelectorUi.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SampleSelectorUi.kt:68)	232ms 961us 254ns	1
com.coldstar.compass_sample.SampleSelectorUi.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SampleSelectorUi.kt:84)	231ms 902us 100ns	1
com.coldstar.compass_sample.SampleSelectorUi.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SampleSelectorUi.kt:76)	231ms 4us 331ns	1
com.coldstar.compass_sample.SampleSelectorUi.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SampleSelectorUi.kt:100)	230ms 968us 947ns	1
com.coldstar.compass_sample.SampleSelectorUi.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SampleSelectorUi.kt:132)	230ms 136us 869ns	1
com.coldstar.compass_sample.SampleSelectorUi.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SampleSelectorUi.kt:116)	229ms 216us 561ns	1
com.coldstar.compass_sample.SampleSelectorUi.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SampleSelectorUi.kt:52)	228ms 769us 331ns	1
com.coldstar.compass_sample.SampleSelectorUi.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SampleSelectorUi.kt:60)	227ms 751us 100ns	1
com.coldstar.compass_sample.SampleSelectorUi.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SampleSelectorUi.kt:92)	224ms 240us 330ns	1
com.coldstar.compass_sample.SampleSelectorUi.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SampleSelectorUi.kt:108)	224ms 194us 484ns	1
com.coldstar.compass_sample.SampleSelectorUi.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SampleSelectorUi.kt:124)	221ms 74us 715ns	1
com.coldstar.compass.stack.PageStack (PageStack.kt:34)	218ms 351us 327ns	8
Compose:applyChanges	202ms 152us 942ns	40
androidx.compose.animation.AnimatedEnterExitImpl (AnimatedVisibility.kt:726)	162ms 598us 245ns	10
com.coldstar.compass.stack.StackNavHost (StackNavHost.kt:57)	161ms 665us 940ns	3
Choreographer#doFrame 11094968	152ms 447us 169ns	1
Recomposer:animation	152ms 228us 171ns	51
androidx.compose.ui.graphics.vector.VectorPainter.composeVector.<anonymous> (VectorPainter.kt:212)	127ms 669us 244ns	13
androidx.compose.ui.graphics.vector.rememberVectorPainter.<anonymous> (VectorPainter.kt:167)	125ms 282us 628ns	13
androidx.compose.ui.graphics.vector.RenderVectorGroup (VectorPainter.kt:327)	124ms 229us 320ns	13
AndroidOwner:measureAndLayout	118ms 531us 243ns	45
com.coldstar.compass.stack.PageStack.<anonymous>.<anonymous>.<anonymous>.<anonymous> (PageStack.kt:99)	98ms 731us 85ns	10
com.coldstar.compass.stack.PageStack.<anonymous>.<anonymous>.<anonymous>.LayerContent (PageStack.kt:56)	98ms 67us 627ns	10
com.coldstar.compass.stack.Render (StackGraph.kt:167)	94ms 693us 856ns	10
com.coldstar.compass.LocalOwnersProvider (NavEntry.kt:144)	89ms 271us 162ns	10
androidx.compose.animation.AnimatedVisibility (AnimatedVisibility.kt:600)	86ms 815us 393ns	2
androidx.compose.ui.platform.WrappedComposition.setContent.<anonymous>.<anonymous> (Wrapper.android.kt:141)	80ms 958us 239ns	1
androidx.compose.ui.platform.WrappedComposition.setContent.<anonymous>.<anonymous>.<anonymous> (Wrapper.android.kt:156)	76ms 789us 853ns	1
androidx.compose.ui.platform.ProvideAndroidCompositionLocals (AndroidCompositionLocals.android.kt:80)	76ms 6us 162ns	1
androidx.compose.ui.graphics.vector.Path (VectorCompose.kt:99)	74ms 789us 777ns	624
androidx.compose.material.Surface (Surface.kt:104)	72ms 773us 930ns	3
androidx.compose.ui.platform.ProvideAndroidCompositionLocals.<anonymous> (AndroidCompositionLocals.android.kt:117)	70ms 391us 315ns	1
com.coldstar.compass.LocalOwnersProvider.<anonymous> (NavEntry.kt:151)	69ms 266us 544ns	10
androidx.compose.ui.platform.ProvideCommonCompositionLocals (CompositionLocals.kt:189)	68ms 943us 469ns	1
com.coldstar.compass.SaveableStateProvider (NavEntry.kt:156)	67ms 553us 314ns	10
androidx.compose.material.Surface.<anonymous> (Surface.kt:117)	67ms 407us 698ns	3
androidx.compose.ui.platform.AbstractComposeView.ensureCompositionCreated.<anonymous> (ComposeView.android.kt:250)	65ms 315us 391ns	1
androidx.compose.ui.platform.ComposeView.Content (ComposeView.android.kt:426)	65ms 116us 853ns	1
com.coldstar.compass_sample.ComposableSingletons.MainActivityKt.lambda-3.<anonymous> (MainActivity.kt:26)	64ms 889us 545ns	1
com.coldstar.compass_sample.ui.theme.CompassSampleTheme (Theme.kt:18)	63ms 945us 929ns	1
androidx.compose.material.Text (Text.kt:92)	63ms 77us 623ns	15
Choreographer#doFrame 11095073	62ms 508us 622ns	1
androidx.compose.material.MaterialTheme (MaterialTheme.kt:58)	58ms 541us 237ns	1
androidx.compose.foundation.text.BasicText (BasicText.kt:79)	56ms 44us 930ns	15
androidx.compose.material.ProvideTextStyle (Text.kt:393)	53ms 879us 928ns	2
measure	53ms 360us 313ns	6
androidx.compose.ui.res.loadVectorResource (PainterResources.android.kt:81)	52ms 292us 541ns	13
androidx.compose.material.MaterialTheme.<anonymous> (MaterialTheme.kt:79)	49ms 728us 82ns	1
AndroidOwner:onMeasure	47ms 655us 467ns	6
androidx.compose.material.MaterialTheme.<anonymous>.<anonymous> (MaterialTheme.kt:80)	47ms 353us 543ns	1
androidx.compose.material.PlatformMaterialTheme (MaterialTheme.android.kt:21)	47ms 135us 82ns	1
com.coldstar.compass_sample.ComposableSingletons.MainActivityKt.lambda-2.<anonymous> (MainActivity.kt:28)	47ms 18us 850ns	1
binder transaction	43ms 828us 925ns	42
androidx.compose.foundation.indication.<anonymous> (Indication.kt:107)	39ms 928us 5ns	13
com.coldstar.compass.stack.Render.<anonymous> (StackGraph.kt:185)	39ms 427us 924ns	10
Choreographer#doFrame 11095116	39ms 3us 4ns	1
androidx.compose.material.ripple.Ripple.rememberUpdatedInstance (Ripple.kt:113)	37ms 986us 389ns	13
androidx.compose.material.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:319)	37ms 784us 696ns	1
com.coldstar.compass_sample.ComposableSingletons.MainActivityKt.lambda-1.<anonymous> (MainActivity.kt:31)	37ms 706us 158ns	1
com.coldstar.compass_sample.SampleSelectorUi.<anonymous> (SampleSelectorUi.kt:36)	37ms 616us 620ns	1
com.coldstar.compass_sample.App (AppUI.kt:41)	37ms 454us 543ns	1
Choreographer#doFrame 11095057	34ms 191us 312ns	1
Choreographer#doFrame 11095067	32ms 912us 927ns	1
androidx.compose.runtime.ComposerImpl.startProviders.<anonymous> (Composer.kt:1994)	30ms 989us 243ns	60
androidx.compose.foundation.lazy.LazyColumn (LazyDsl.kt:345)	30ms 669us 542ns	1
androidx.compose.foundation.lazy.LazyList (LazyList.kt:50)	30ms 301us 542ns	1
Choreographer#doFrame 11094979	29ms 180us 234ns	1
androidx.compose.runtime.compositionLocalMapOf (CompositionLocalMap.kt:91)	27ms 939us 847ns	60
com.coldstar.compass_sample.App.<anonymous>.<anonymous> (AppUI.kt:55)	22ms 361us 541ns	1
androidx.compose.ui.layout.materializerOf.<anonymous> (Layout.kt:201)	21ms 998us 306ns	53
com.coldstar.compass_sample.SampleSelectorUi (SampleSelectorUi.kt:25)	21ms 822us 79ns	1
com.coldstar.compass_sample.ComposableSingletons.SampleSelectorUiKt.lambda-2.<anonymous> (SampleSelectorUi.kt:30)	21ms 349us 540ns	1
activityResume	20ms 961us 2ns	1
androidx.compose.material.TopAppBar (AppBar.kt:76)	19ms 399us 2ns	1
androidx.compose.material.AppBar (AppBar.kt:504)	19ms 75us 925ns	1
Compose:onRemembered	18ms 885us 696ns	18
relayoutWindow	17ms 958us 79ns	1
Choreographer#doFrame 11095021	17ms 344us 2ns	1
androidx.compose.animation.core.updateTransition (Transition.kt:67)	16ms 736us 309ns	8
androidx.compose.runtime.saveable.rememberSaveable (RememberSaveable.kt:65)	16ms 637us 464ns	12
androidx.compose.material.ripple.PlatformRipple.rememberUpdatedRippleInstance (Ripple.android.kt:57)	16ms 255us 309ns	13
Choreographer#doFrame 11095012	15ms 501us 848ns	1
Choreographer#doFrame 11095084	14ms 65us 771ns	1
androidx.compose.foundation.lazy.layout.LazyLayout (LazyLayout.kt:52)	13ms 894us 386ns	1
androidx.compose.material.AppBar.<anonymous> (AppBar.kt:519)	13ms 764us 309ns	1
androidx.compose.foundation.lazy.layout.LazySaveableStateHolderProvider (LazySaveableStateHolder.kt:41)	13ms 389us 770ns	1
Choreographer#doFrame 11095082	12ms 894us 771ns	1
com.coldstar.compass_sample.ComposableSingletons.AppUIKt.lambda-1.<anonymous> (AppUI.kt:50)	12ms 848us 847ns	1
ResourcesManager#getResources	12ms 657us 155ns	3
Choreographer#doFrame 11095009	12ms 526us 232ns	1
Choreographer#doFrame 11095031	12ms 344us 78ns	1
Choreographer#doFrame 11095071	12ms 248us 925ns	1
androidx.compose.material.AppBar.<anonymous>.<anonymous> (AppBar.kt:520)	12ms 135us 693ns	1
com.coldstar.compass_sample.SplashPageUI (SplashUI.kt:14)	12ms 132us 1ns	1
Choreographer#doFrame 11095059	12ms 61us 540ns	1
androidx.compose.animation.createModifier (EnterExitTransition.kt:819)	11ms 906us 156ns	10
Choreographer#doFrame 11095078	11ms 851us 308ns	1
ResourcesImpl#updateConfiguration	11ms 407us 78ns	2
Choreographer#doFrame 11095088	11ms 208us 1ns	1
androidx.compose.runtime.saveable.rememberSaveableStateHolder (SaveableStateHolder.kt:58)	11ms 82us 308ns	9
Choreographer#doFrame 11095080	10ms 833us 232ns	1
androidx.compose.foundation.lazy.layout.LazySaveableStateHolderProvider.<anonymous> (LazySaveableStateHolder.kt:48)	10ms 781us 847ns	1
Choreographer#scheduleVsyncLocked	10ms 596us 768ns	57
androidx.compose.foundation.Image (Image.kt:235)	10ms 463us 846ns	13
Choreographer#doFrame 11095001	10ms 346us 78ns	1
androidx.compose.runtime.rememberUpdatedState (SnapshotState.kt:303)	10ms 229us 465ns	99
androidx.compose.material.Scaffold (Scaffold.kt:158)	9ms 936us 1ns	1
androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:254)	9ms 838us 78ns	2
androidx.compose.foundation.lazy.layout.LazyLayout.<anonymous> (LazyLayout.kt:60)	9ms 681us 232ns	1
Choreographer#doFrame 11095090	9ms 521us 616ns	1
Choreographer#doFrame 11095075	9ms 447us 1ns	1
Choreographer#doFrame 11095025	9ms 370us 385ns	1
Choreographer#doFrame 11095086	9ms 310us 539ns	1
AssetManager::GetResourceLocales	9ms 261us 384ns	3
Choreographer#doFrame 11095102	9ms 255us 78ns	1
androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:310)	9ms 253us 232ns	2
androidx.compose.material.TopAppBar.<anonymous> (AppBar.kt:92)	9ms 110us 462ns	1
androidx.compose.runtime.DisposableEffect (Effects.kt:151)	9ms 67us 312ns	123
androidx.compose.material.Scaffold.<anonymous> (Scaffold.kt:178)	8ms 950us 386ns	1
androidx.compose.animation.slideInOut.<anonymous> (EnterExitTransition.kt:949)	8ms 940us 78ns	10
Choreographer#doFrame 11095100	8ms 871us 770ns	1
Choreographer#doFrame 11095098	8ms 862us 78ns	1
Choreographer#doFrame 11095108	8ms 654us 232ns	1
Choreographer#doFrame 11095092	8ms 557us 231ns	1
Choreographer#doFrame 11095096	8ms 292us 1ns	1
Choreographer#doFrame 11095094	8ms 251us 385ns	1
Choreographer#doFrame 11095104	8ms 211us	1
androidx.compose.animation.core.Transition.animateTo (Transition.kt:425)	8ms 134us 538ns	8
Choreographer#doFrame 11095106	8ms 64us 1ns	1
Choreographer#doFrame 11095110	7ms 727us 386ns	1
androidx.compose.animation.core.createChildTransitionInternal (Transition.kt:794)	7ms 613us	10
androidx.compose.animation.AnimatedEnterExitImpl.<anonymous> (AnimatedVisibility.kt:739)	7ms 418us 693ns	20
Choreographer#doFrame 11095023	7ms 374us 770ns	1
Choreographer#doFrame 11095055	7ms 209us 847ns	1
Choreographer#doFrame 11095114	7ms 39us 462ns	1
Choreographer#doFrame 11095033	6ms 398us 769ns	1
androidx.compose.animation.targetEnterExit (AnimatedVisibility.kt:830)	6ms 79us 695ns	20
Choreographer#doFrame 11095015	6ms 44us 693ns	1
Choreographer#doFrame 11095041	5ms 997us 232ns	1
Choreographer#doFrame 11095039	5ms 922us 462ns	1
androidx.compose.material.MaterialRippleTheme.defaultColor (MaterialTheme.kt:127)	5ms 785us 540ns	13
androidx.compose.foundation.gestures.scrollable.<anonymous> (Scrollable.kt:161)	5ms 746us 462ns	1
Choreographer#doFrame 11095027	5ms 732us 693ns	1
Choreographer#doFrame 11095017	5ms 720us 308ns	1
Choreographer#doFrame 11095029	5ms 493us 847ns	1
Choreographer#doFrame 11095019	5ms 471us 77ns	1
Choreographer#doFrame 11095035	5ms 391us 924ns	1
Choreographer#doFrame 11095037	5ms 211us 693ns	1
Choreographer#doFrame 11095045	5ms 209us 924ns	1
androidx.compose.runtime.rememberCompositionContext (Composables.kt:480)	5ms 88us 924ns	15
Choreographer#doFrame 11095049	4ms 892us 924ns	1
Choreographer#doFrame 11095047	4ms 880us 615ns	1
Choreographer#doFrame 11095043	4ms 880us	1
androidx.compose.ui.res.resources (Resources.android.kt:30)	4ms 876us	13
androidx.compose.foundation.lazy.ScrollPositionUpdater (LazyList.kt:140)	4ms 846us 231ns	1
Choreographer#doFrame 11095051	4ms 736us 231ns	1
androidx.compose.runtime.DynamicProvidableCompositionLocal.provided (CompositionLocal.kt:125)	4ms 683us 851ns	47
Choreographer#doFrame 11095112	4ms 562us 385ns	1
com.coldstar.compass.getNavController (NavController.kt:15)	4ms 539us 463ns	2
androidx.compose.animation.core.Transition.updateTarget (Transition.kt:400)	4ms 425us 309ns	14
androidx.compose.foundation.gestures.ScrollableDefaults.overscrollEffect (Scrollable.kt:206)	4ms 224us 924ns	1
VerifyClass androidx.compose.runtime.snapshots.SnapshotStateList	4ms 133us 154ns	1
androidx.compose.foundation.lazy.rememberLazyListState (LazyListState.kt:57)	4ms 104us 616ns	1
MSG_WINDOW_FOCUS_CHANGED	4ms 22us 154ns	1
androidx.compose.material.Scaffold.<anonymous>.<anonymous> (Scaffold.kt:179)	3ms 967us 616ns	1
androidx.compose.material.rememberDrawerState (Drawer.kt:451)	3ms 957us 154ns	1
TextLayout:initLayout	3ms 737us 386ns	16
androidx.compose.material.Scaffold.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:185)	3ms 675us 1ns	1
androidx.compose.runtime.LaunchedEffect (Effects.kt:333)	3ms 650us 152ns	28
MSG_INSETS_CONTROL_CHANGED	3ms 596us 615ns	2
androidx.compose.foundation.clickable.<anonymous> (Clickable.kt:97)	3ms 577us 539ns	13
androidx.compose.material.ScaffoldLayout (Scaffold.kt:227)	3ms 548us 385ns	1
androidx.compose.material.ComposableSingletons.ScaffoldKt.lambda-3.<anonymous> (Scaffold.kt:163)	3ms 509us 770ns	1
com.coldstar.compass.core.rememberRootNavController (RootNavController.kt:28)	3ms 503us 616ns	1
androidx.compose.material.MaterialTheme.<get-colors> (MaterialTheme.kt:102)	3ms 500us 464ns	47
androidx.compose.foundation.rememberOverscrollEffect (AndroidOverscroll.kt:62)	3ms 257us 923ns	1
androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:72)	3ms 106us 693ns	1
androidx.compose.animation.core.createDeferredAnimation (Transition.kt:749)	3ms 98us 460ns	6
androidx.compose.material.SnackbarHost (SnackbarHost.kt:150)	2ms 988us 1ns	1
androidx.compose.foundation.gestures.pointerScrollable (Scrollable.kt:247)	2ms 909us 846ns	1
androidx.compose.material.MaterialRippleTheme.rippleAlpha (MaterialTheme.kt:133)	2ms 897us 613ns	13
androidx.compose.material.surfaceColorAtElevation (Surface.kt:630)	2ms 783us 922ns	3
androidx.compose.material.TopAppBar.<anonymous>.<anonymous>.<anonymous> (AppBar.kt:108)	2ms 701us 769ns	1
androidx.compose.material.ContentAlpha.contentAlpha (ContentAlpha.kt:70)	2ms 696us 616ns	5
androidx.compose.material.rememberTextSelectionColors (MaterialTextSelectionColors.kt:35)	2ms 556us 692ns	1
Compose:onForgotten	2ms 547us 847ns	2
AssetManager::SetApkAssets	2ms 440us 77ns	2
ResourcesManager#createBaseActivityResources	2ms 420us 923ns	1
VerifyClass androidx.compose.runtime.snapshots.SnapshotStateMap	2ms 375us	1
Choreographer#doFrame 11095053	2ms 371us 385ns	1
androidx.compose.material.ContentAlpha.<get-medium> (ContentAlpha.kt:45)	2ms 328us 462ns	3
androidx.compose.foundation.lazy.rememberLazyListItemProviderLambda (LazyListItemProvider.kt:40)	2ms 163us 78ns	1
androidx.compose.material.contentColorFor (Colors.kt:295)	2ms 114us 156ns	5
androidx.compose.runtime.<get-currentCompositeKeyHash> (Composables.kt:224)	2ms 89us 153ns	135
androidx.compose.animation.shrinkExpand.<anonymous> (EnterExitTransition.kt:1030)	2ms 33us 847ns	10
androidx.compose.runtime.LaunchedEffect (Effects.kt:355)	1ms 848us 306ns	13
androidx.compose.foundation.gestures.ScrollableDefaults.flingBehavior (Scrollable.kt:193)	1ms 843us	1
inflate	1ms 809us 231ns	1
Theme::ApplyStyle	1ms 807us	7
androidx.compose.material.DefaultElevationOverlay.apply (ElevationOverlay.kt:68)	1ms 720us 770ns	3
androidx.compose.foundation.lazy.layout.lazyLayoutSemantics (LazyLayoutSemantics.kt:40)	1ms 621us 846ns	1
Compose:sideeffects	1ms 397us 384ns	7
com.coldstar.compass_sample.ComposableSingletons.SampleSelectorUiKt.lambda-1.<anonymous> (SampleSelectorUi.kt:31)	1ms 391us 77ns	1
androidx.compose.runtime.StaticProvidableCompositionLocal.provided (CompositionLocal.kt:139)	1ms 385us 386ns	75
androidx.compose.runtime.DisposableEffect (Effects.kt:190)	1ms 228us 463ns	16
onCreateView:ViewStub	1ms 75us 770ns	1
ViewStub	1ms 2us 385ns	4
androidx.compose.material.FadeInFadeOutWithScale (SnackbarHost.kt:256)	964us 846ns	1
EmojiCompat.EmojiCompatInitializer.run	899us 385ns	1
androidx.compose.foundation.lazy.layout.LazyLayoutPrefetcher (LazyLayoutPrefetcher.android.kt:35)	895us 616ns	1
monitor contention with owner Binder:26478_2 (15) at void android.os.MessageQueue.nativeWake(long)(MessageQueue.java:-2) waiters=0 blocking from android.os.Message android.os.MessageQueue.next()(MessageQueue.java:337)	867us 461ns	1
AssetManager::SetConfiguration	860us 693ns	2
androidx.compose.material.TopAppBar.<anonymous>.<anonymous> (AppBar.kt:116)	847us 692ns	1
Lock contention on a monitor lock (owner tid: 26497)	846us 154ns	1
androidx.compose.material.ScaffoldLayout.<anonymous>.<anonymous>.<anonymous>.<anonymous> (Scaffold.kt:288)	842us 693ns	1
androidx.compose.material.ContentAlpha.<get-high> (ContentAlpha.kt:34)	824us 384ns	2
AssetManager::OpenXmlAsset(res/Xc.xml)	808us 385ns	1
androidx.compose.animation.rememberSplineBasedDecay (SplineBasedFloatDecayAnimationSpec.android.kt:40)	776us 615ns	1
androidx.compose.material.ripple.PlatformRipple.findNearestViewGroup (Ripple.android.kt:104)	758us 539ns	13
androidx.compose.foundation.layout.rememberBoxMeasurePolicy (Box.kt:79)	743us 771ns	13
performResume:com.coldstar.compass_sample.MainActivity	732us 539ns	1
topResumedActivityChangeItem	651us 692ns	1
androidx.compose.foundation.lazy.lazyListBeyondBoundsModifier (LazyListBeyondBoundsModifier.kt:32)	638us 154ns	1
androidx.compose.foundation.layout.rowMeasurePolicy (Row.kt:100)	573us 770ns	16
androidx.compose.foundation.layout.Spacer (Spacer.kt:38)	566us 539ns	1
providerRemove	562us 539ns	1
androidx.compose.ui.platform.obtainImageVectorCache (AndroidCompositionLocals.android.kt:128)	540us 616ns	1
Loading font /data/fonts/files/~~iDyw0kIIl0CBiUefuOtFyA==/NotoColorEmoji.ttf	515us	1
reportFullyDrawn() for ComponentActivity	483us 77ns	1
androidx.compose.material.ripple.rememberRipple (Ripple.kt:76)	468us 385ns	1
androidx.compose.runtime.SideEffect (Effects.kt:45)	438us 923ns	9
androidx.compose.material.calculateForegroundColor (ElevationOverlay.kt:86)	409us 538ns	1
dispatchApplyInsets	408us 847ns	1
AssetManager::OpenXmlAsset(res/interpolator/linear_out_slow_in.xml)	399us	1
Loading font /system/fonts/RobotoStatic-Regular.ttf	369us	1
androidx.compose.material.DrawerDefaults.<get-scrimColor> (Drawer.kt:787)	365us 461ns	1
commit	361us 770ns	1
androidx.compose.runtime.DisposableEffect (Effects.kt:230)	348us 77ns	3
Run checkpoint function	331us 385ns	8
AssetManager::OpenXmlAsset(res/iH.xml)	313us 231ns	1
AssetManager::OpenXmlAsset(res/hG.xml)	296us 923ns	1
Loading font /system/fonts/Roboto-Regular.ttf	290us 384ns	1
androidx.compose.foundation.lazy.rememberLazyListSemanticState (LazyListSemantics.kt:23)	276us 539ns	1
HWUI:android.view.View	275us 153ns	2
virtual void art::jit::MarkCodeClosure::Run(art::Thread *)	273us 231ns	2
onCreateView:LinearLayout	273us 230ns	1
Choreographer#onVsync 11095082	264us 615ns	1
LinearLayout	257us 538ns	1
Choreographer#onVsync 11095116	255us 384ns	1
AssetManager::OpenXmlAsset(res/Qf.xml)	246us 847ns	1
trimMemory	242us 462ns	1
AssetManager::OpenXmlAsset(res/oZ.xml)	236us 846ns	1
Choreographer#onVsync 11095084	232us 692ns	1
AssetManager::OpenXmlAsset(res/_t.xml)	231us 692ns	1
computePalette	225us 308ns	13
AssetManager::OpenXmlAsset(res/Oa.xml)	223us 693ns	1
onCreateView:FrameLayout	216us 231ns	1
AssetManager::OpenXmlAsset(res/PO.xml)	213us 846ns	1
connect	213us 615ns	1
AssetManager::OpenXmlAsset(res/x4.xml)	213us 231ns	1
AssetManager::OpenXmlAsset(res/cF.xml)	212us 308ns	1
AssetManager::OpenXmlAsset(res/L4.xml)	209us 539ns	1
AssetManager::OpenXmlAsset(res/transition/fade.xml)	206us 154ns	1
FrameLayout	205us 231ns	1
reportFullyDrawn() for {com.coldstar.compass_sample/com.coldstar.compass_sample.MainActivity}	204us	1
Choreographer#onVsync 11095090	201us 231ns	1
Choreographer#onVsync 11095108	201us 154ns	1
AssetManager::OpenXmlAsset(res/yc.xml)	195us 384ns	1
androidx.compose.material.rememberScaffoldState (Scaffold.kt:62)	191us 615ns	1
Choreographer#onVsync 11095112	190us 154ns	1
Compose:releases	189us 539ns	1
Choreographer#onVsync 11095114	186us 846ns	1
Choreographer#onVsync 11095012	186us 538ns	1
Choreographer#onVsync 11095102	184us 923ns	1
AssetManager::OpenXmlAsset(res/vk.xml)	184us 385ns	1
AssetManager::OpenXmlAsset(res/_e.xml)	181us 461ns	1
Choreographer#onVsync 11095098	181us 231ns	1
Choreographer#onVsync 11095092	179us 77ns	1
AssetManager::OpenXmlAsset(res/f1.xml)	176us 615ns	1
Choreographer#onVsync 11095088	176us 385ns	1
androidx.compose.foundation.lazy.rememberLazyListMeasurePolicy (LazyList.kt:152)	176us	1
Choreographer#onVsync 11095021	174us 77ns	1
Choreographer#onVsync 11095106	173us 847ns	1
AssetManager::OpenXmlAsset(res/nQ.xml)	173us 769ns	1
Choreographer#onVsync 11095104	173us 539ns	1
hintActivityLaunch	171us 384ns	1
Choreographer#onVsync 11095055	169us 847ns	1
Choreographer#onVsync 11095080	168us 307ns	1
Choreographer#onVsync 11095057	166us 769ns	1
AssetManager::OpenXmlAsset(res/Tc.xml)	165us 615ns	1
Compose:unobserve	165us 231ns	1
AssetManager::OpenXmlAsset(res/layout/screen_simple.xml)	160us 693ns	1
ResourcesManager#createApkAssetsSupplierNotLocked	160us 692ns	3
Choreographer#onVsync 11095096	159us 616ns	1
androidx.compose.material.MaterialTheme.<get-shapes> (MaterialTheme.kt:120)	159us 384ns	1
Choreographer#onVsync 11095065	159us	1
Choreographer#onVsync 11095110	158us 461ns	1
Choreographer#onVsync 11095094	157us 539ns	1
finish draw	156us 923ns	1
Choreographer#onVsync 11095100	155us 77ns	1
Lock contention on thread suspend count lock (owner tid: 26492)	153us 769ns	3
AssetManager::OpenXmlAsset(res/w-.xml)	147us 923ns	1
AssetManager::OpenXmlAsset(res/Ts.xml)	147us 923ns	1
Choreographer#onVsync 11095025	147us	1
AssetManager::OpenXmlAsset(res/rx.xml)	146us 692ns	1
AssetManager::OpenXmlAsset(res/ys.xml)	145us 846ns	1
Choreographer#onVsync 11095063	145us 538ns	1
Choreographer#onVsync 11095086	139us 153ns	1
Choreographer#onVsync 11095033	135us	1
androidx.compose.foundation.gestures.platformScrollConfig (AndroidScrollable.android.kt:27)	133us 846ns	1
AssetManager::OpenXmlAsset(res/lx.xml)	133us 308ns	1
AssetManager::OpenXmlAsset(res/Vi.xml)	131us 769ns	1
Choreographer#onVsync 11095029	130us 769ns	1
Choreographer#onVsync 11095041	129us	1
Choreographer#onVsync 11095045	128us 308ns	1
Choreographer#onVsync 11095039	128us 231ns	1
Choreographer#onVsync 11095123	128us	1
Choreographer#onVsync 11095031	127us 693ns	1
Choreographer#onVsync 11095037	127us 77ns	1
Choreographer#onVsync 11095043	126us 692ns	1
Choreographer#onVsync 11095051	126us 461ns	1
Choreographer#onVsync 11095035	126us 154ns	1
Choreographer#onVsync 11095053	125us 923ns	1
AssetManager::GetResourceConfigurations	125us 923ns	1
Choreographer#onVsync 11094962	123us 308ns	1
AssetManager::OpenXmlAsset(res/wC.xml)	121us 308ns	1
Choreographer#onVsync 11095027	120us 923ns	1
Choreographer#onVsync 11095017	118us 385ns	1
Choreographer#onVsync 11095047	117us 923ns	1
Choreographer#onVsync 11095049	115us 153ns	1
Choreographer#onVsync 11095073	114us 462ns	1
Choreographer#onVsync 11095019	114us 385ns	1
AssetManager::OpenXmlAsset(res/-N.xml)	113us 769ns	1
Choreographer#onVsync 11095009	107us 384ns	1
AssetManager::OpenXmlAsset(res/-o.xml)	106us 538ns	1
AssetManager::OpenXmlAsset(res/F1.xml)	106us 461ns	1
AssetManager::OpenXmlAsset(res/4r.xml)	104us 923ns	1
AssetManager::OpenXmlAsset(res/fx.xml)	103us 693ns	1
AssetManager::OpenXmlAsset(res/6K.xml)	103us 692ns	1
AssetManager::OpenXmlAsset(res/rM.xml)	103us 308ns	1
AssetManager::OpenXmlAsset(res/interpolator/fast_out_linear_in.xml)	101us 231ns	1
AssetManager::OpenXmlAsset(res/H1.xml)	97us 231ns	1
AssetManager::OpenXmlAsset(res/1G.xml)	95us 461ns	1
AssetManager::OpenXmlAsset(res/hH.xml)	93us 615ns	1
FullSuspendCheck	93us 154ns	1
androidx.compose.material.MaterialTheme.<get-typography> (MaterialTheme.kt:112)	92us 923ns	1
AssetManager::OpenXmlAsset(res/transition/move.xml)	88us 923ns	1
Choreographer#onVsync 11094979	80us 923ns	1
Choreographer#onVsync 11095078	80us 847ns	1
Choreographer#onVsync 11095023	75us 77ns	1
Choreographer#onVsync 11095059	73us 846ns	1
Choreographer#onVsync 11095075	68us	1
Choreographer#onVsync 11095067	67us 385ns	1
Choreographer#onVsync 11095015	61us 616ns	1
Choreographer#onVsync 11094968	56us 615ns	1
Choreographer#onVsync 11095118	54us 769ns	1
Choreographer#onVsync 11095071	54us 692ns	1
Choreographer#onVsync 11095001	54us 77ns	1
setMaxDequeuedBufferCount	52us 307ns	1
notifyContentCapture(START) for {com.coldstar.compass_sample/com.coldstar.compass_sample.MainActivity}	35us 384ns	1
open	26us 616ns	3
setMaxAcquiredBufferCount	26us 462ns	2
Lock contention on thread suspend count lock (owner tid: 26633)	23us 616ns	2
ResourcesManager#updateResourcesForActivity	22us 769ns	1
Lock contention on InternTable lock (owner tid: 26491)	21us 922ns	3
SuspendThreadByThreadId suspended Binder:26478_2 id=15	21us 307ns	1
Lock contention on ClassLinker classes lock (owner tid: 18446744073709551615)	20us 615ns	3
setDequeueTimeout	19us 692ns	1
waitWhileAllocatingLocked	17us 924ns	3
Choreographer#doFrame 11095063	17us 616ns	1
Lock contention on thread suspend count lock (owner tid: 26491)	16us 769ns	2
androidx.compose.material.ComposableSingletons.ScaffoldKt.lambda-4.<anonymous> (Scaffold.kt:164)	14us 770ns	1
Choreographer#doFrame 11095123	14us 692ns	1
androidx.compose.runtime.<get-currentRecomposeScope> (Composables.kt:192)	13us 231ns	1
dispatchContentCapture() for ViewRootImpl	11us 616ns	1
createView by com.coldstar.compass_sample.MainActivity@d9366dc-LinearLayout	11us 384ns	1
setConsumerName	11us 308ns	2
ResourcesManager#applyConfigurationToResources	9us 539ns	2
androidx.compose.material.ComposableSingletons.AppBarKt.lambda-1.<anonymous> (AppBar.kt:80)	9us 538ns	1
androidx.compose.material.ComposableSingletons.ScaffoldKt.lambda-2.<anonymous> (Scaffold.kt:162)	9us 154ns	1
notifyContentCapture(RESUME) for {com.coldstar.compass_sample/com.coldstar.compass_sample.MainActivity}	8us 923ns	1
MSG_CHECK_FOCUS	8us 77ns	1
Lock contention on Region lock (owner tid: 26633)	7us 154ns	1
createView by com.coldstar.compass_sample.MainActivity@d9366dc-FrameLayout	6us 154ns	1
flushContentCapture for ViewRootImpl	4us 924ns	1
createView by com.coldstar.compass_sample.MainActivity@d9366dc-ViewStub	4us 923ns	1
Lock contention on GC barrier lock (owner tid: 26492)	4us 231ns	1
setTransformHint	3us 308ns	1
setConsumerUsageBits	2us 846ns	1
setDefaultBufferSize	2us 769ns	1
setDefaultBufferFormat	2us 769ns	1
binder transaction async	0s	68
Choreographer#doFrame 11095118	0s	1"""