package me.ash.reader.ui.page.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import me.ash.reader.R
import me.ash.reader.ui.component.Banner
import me.ash.reader.ui.component.DisplayText
import me.ash.reader.ui.component.FeedbackIconButton
import me.ash.reader.ui.component.SelectableSettingGroupItem
import me.ash.reader.ui.page.common.RouteName

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsPage(
    navController: NavHostController,
) {
    Scaffold(
        modifier = Modifier.background(MaterialTheme.colorScheme.surface),
        topBar = {
            SmallTopAppBar(
                title = {},
                navigationIcon = {
                    FeedbackIconButton(
                        imageVector = Icons.Rounded.ArrowBack,
                        contentDescription = stringResource(R.string.back),
                        tint = MaterialTheme.colorScheme.onSurface
                    ) {
                        navController.navigate(RouteName.HOME)
                    }
                },
                actions = {}
            )
        },
        content = {
            LazyColumn {
                item {
                    DisplayText(text = stringResource(R.string.settings), desc = "")
                }
                item {
                    Banner(
                        title = stringResource(R.string.get_new_updates),
                        desc = stringResource(R.string.get_new_updates_desc),
                        icon = Icons.Outlined.Lightbulb,
                        action = {
                            Icon(
                                imageVector = Icons.Rounded.Close,
                                contentDescription = stringResource(R.string.close),
                            )
                        },
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                }
                item {
                    SelectableSettingGroupItem(
                        title = stringResource(R.string.accounts),
                        desc = stringResource(R.string.accounts_desc),
                        icon = Icons.Outlined.AccountCircle,
                    ) {}
                }
                item {
                    SelectableSettingGroupItem(
                        title = stringResource(R.string.color_and_style),
                        desc = stringResource(R.string.color_and_style_desc),
                        icon = Icons.Outlined.Palette,
                    ) {}
                }
                item {
                    SelectableSettingGroupItem(
                        title = stringResource(R.string.interaction),
                        desc = stringResource(R.string.interaction_desc),
                        icon = Icons.Outlined.TouchApp,
                    ) {}
                }
                item {
                    SelectableSettingGroupItem(
                        title = stringResource(R.string.languages),
                        desc = stringResource(R.string.languages_desc),
                        icon = Icons.Outlined.Language,
                    ) {}
                }
                item {
                    SelectableSettingGroupItem(
                        title = stringResource(R.string.tips_and_support),
                        desc = stringResource(R.string.tips_and_support_desc),
                        icon = Icons.Outlined.TipsAndUpdates,
                    ) {}
                }
            }
        }
    )
}
