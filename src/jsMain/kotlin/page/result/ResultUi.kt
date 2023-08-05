package page.result

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import common.ErrorUi
import common.Header
import org.jetbrains.compose.web.dom.Div
import repo.PivotRepoImpl

@Composable
fun ResultPage(
    viewModel: ResultViewModel = remember {
        ResultViewModel(
            PivotRepoImpl()
        )
    }
) {

    Div(
        attrs = {
            classes("container-fluid")
        }
    ) {
        // Header
        Header()

        // Error
        if (viewModel.errorMsg.isNotBlank()) {
            ErrorUi(viewModel.errorMsg)
        }

    }
}