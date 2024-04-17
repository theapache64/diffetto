package page.input

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import common.Header
import org.jetbrains.compose.web.dom.Div
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
                inputViewModel.onTitleClicked()
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
