package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Suppress("SpellCheckingInspection")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormDataDiri(modifier: Modifier = Modifier) {
    var textNamaDepan by remember { mutableStateOf("") }
    var textNamaBelakang by remember { mutableStateOf("") }
    var textEmail by remember { mutableStateOf("") }
    var textTanggalLahir by remember { mutableStateOf("") }
    var textPengalaman by remember { mutableStateOf("") }

    var isAndroidChecked by remember { mutableStateOf(false) }
    var isUiUxChecked by remember { mutableStateOf(false) }
    var isWebChecked by remember { mutableStateOf(false) }

    var expandedPengalaman by remember { mutableStateOf(false) }
    val opsiPengalaman = listOf("0-1 tahun", "1-3 tahun", "3-5 tahun")
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()

    var namaDepan by remember { mutableStateOf("") }
    var namaBelakang by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tanggalLahir by remember { mutableStateOf("") }
    var pengalaman by remember { mutableStateOf("") }
    var skills by remember { mutableStateOf("") }
    var isProceedClicked by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.fotogua),
            contentDescription = stringResource(id = R.string.desc_background),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.35f)
                .align(Alignment.TopCenter),
            contentScale = ContentScale.Crop
        )
        IconButton(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 20.dp, top = 36.dp)
                .background(Color.White, shape = CircleShape)
                .size(dimensionResource(id = R.dimen.height_menu_button)),
            onClick = { }
        ) {
            Icon(
                painter = painterResource(id = android.R.drawable.ic_menu_sort_by_size),
                contentDescription = stringResource(id = R.string.desc_menu),
                tint = Color.Gray
            )
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.75f)
                .align(Alignment.BottomCenter),
            shape = RoundedCornerShape(
                topStart = dimensionResource(id = R.dimen.radius_card_main),
                topEnd = dimensionResource(id = R.dimen.radius_card_main),
                bottomStart = 0.dp,
                bottomEnd = 0.dp
            ),
            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.card_background))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = dimensionResource(id = R.dimen.padding_screen_horizontal))
                        .padding(top = dimensionResource(id = R.dimen.padding_form_vertical)),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.title_biodata),
                        color = colorResource(id = R.color.purple_primary),
                        fontSize = dimensionResource(id = R.dimen.font_title).value.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_small)))
                    Text(
                        text = stringResource(id = R.string.subtitle_form_biodata),
                        color = colorResource(id = R.color.text_subtitle),
                        fontSize = dimensionResource(id = R.dimen.font_subtitle).value.sp
                    )

                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_medium)))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        OutlinedTextField(
                            value = textNamaDepan,
                            singleLine = true,
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.radius_textfield)),
                            modifier = Modifier
                                .weight(1f)
                                .padding(end = 6.dp),
                            label = { Text(stringResource(id = R.string.first_name), fontSize = dimensionResource(id = R.dimen.font_label).value.sp) },
                            onValueChange = { textNamaDepan = it }
                        )
                        OutlinedTextField(
                            value = textNamaBelakang,
                            singleLine = true,
                            shape = RoundedCornerShape(dimensionResource(id = R.dimen.radius_textfield)),
                            modifier = Modifier
                                .weight(1f)
                                .padding(start = 6.dp),
                            label = { Text(stringResource(id = R.string.last_name), fontSize = dimensionResource(id = R.dimen.font_label).value.sp) },
                            onValueChange = { textNamaBelakang = it }
                        )
                    }
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_small)))

                    OutlinedTextField(
                        value = textEmail,
                        singleLine = true,
                        shape = RoundedCornerShape(dimensionResource(id = R.dimen.radius_textfield)),
                        modifier = Modifier.fillMaxWidth(),
                        label = { Text(stringResource(id = R.string.email), fontSize = dimensionResource(id = R.dimen.font_label).value.sp) },
                        onValueChange = { textEmail = it }
                    )
                    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.spacing_small)))

                }
            }
        }
    }
}