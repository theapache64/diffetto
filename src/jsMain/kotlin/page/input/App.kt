package page.input

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import common.Header
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.bottom
import org.jetbrains.compose.web.css.marginTop
import org.jetbrains.compose.web.css.paddingBottom
import org.jetbrains.compose.web.css.paddingLeft
import org.jetbrains.compose.web.css.paddingRight
import org.jetbrains.compose.web.css.position
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text
import page.result.ResultUi
import repo.CacheRepoImpl


@Composable
fun App(
    inputViewModel: InputViewModel = remember {
        InputViewModel(
            CacheRepoImpl()
        )
    },

    ) {
    Div(
        attrs = {
            classes("container-fluid")
        }
    ) {

        // Header
        Header(
            onTitleClicked = {
                onTitleClicked()
            }
        )

        if (inputViewModel.isReadyToShowPivotData) {
            ResultUi(
                pivotData = inputViewModel.pivotData
            )
        } else {
            InputUi(inputViewModel)
        }

    }
}
