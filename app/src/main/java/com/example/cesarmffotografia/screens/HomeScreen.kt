package com.example.cesarmffotografia.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.cesarmffotografia.R
import com.example.cesarmffotografia.screens.components.AppHeader
import com.google.firebase.auth.FirebaseAuth

data class PhotoItem(
    val image: Int,
    val title: String,
    val description: String
)

@Composable
fun HomeScreen(
    onLogout: () -> Unit
) {

    val auth = FirebaseAuth.getInstance()

    val photos = listOf(
        PhotoItem(
            image = R.drawable.img1906,
            title = "O Voo do 14-Bis - 1906",
            description = "Representou a entrada do Brasil no mundo da aviação pelo 14-Bis de Santos Dumont."
        ),

        PhotoItem(
            image = R.drawable.img1910,
            title = "O Cotidiano Carioca de Augusto Malta - 1910",
            description = "Demonstra a crescente urbanização do país, com bondes elétricos e novas avenidas."
        ),

        PhotoItem(
            image = R.drawable.img1922,
            title = "Semana da Arte Moderna - 1922",
            description = "O mais importante momento para o Modernismo Brasileiro, movimento que rompeu com os padrões de arte conservadores da Europa."
        ),

        PhotoItem(
            image = R.drawable.img1932,
            title = "Os Soldados da Revolução Constitucionalista - 1932",
            description = "Mostra os jovens que na época lutaram para garantir uma nova república."
        ),

        PhotoItem(
            image = R.drawable.img1944,
            title = "O Embarque da FEB para a Itália - 1944",
            description = "Brasil se junta com os aliados na Segunda Guerra Mundial."
        ),

        PhotoItem(
            image = R.drawable.img1958,
            title = "A Construção de Brasília por Marcel Gautherot - 1958",
            description = "A construção de uma nova capital do Brasil, ordenada por Juscelino Kubitschek."
        ),

        PhotoItem(
            image = R.drawable.img1968,
            title = "A Passeata dos Cem Mil - 1968",
            description = "Milhares de pessoas se manifestaram contra a ditadura militar a procura da redemocratização do Brasil."
        ),

        PhotoItem(
            image = R.drawable.img1970,
            title = "O Coração do Rei - 1970",
            description = "Uma das imagens mais importantes do esporte brasileiro, representando o auge do futebol do país."
        ),

        PhotoItem(
            image = R.drawable.img1986,
            title = "O garimpo de Serra Pelada por Sebastião Salgado - 1986",
            description = "Demonstra as deploráveis condições de trabalho e exploração da Amazônia do garimpo."
        ),

        PhotoItem(
            image = R.drawable.img1991,
            title = "Ayrton Senna com a Bandeira do Brasil em Interlagos - 1991",
            description = "Representou orgulho e esperança a um Brasil que estava em grave crise econômica e institucional."
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        AppHeader()

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {

            items(photos) { photo ->

                PhotoSlot(
                    image = photo.image,
                    title = photo.title,
                    description = photo.description
                )
            }
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Button(
            onClick = {

                auth.signOut()

                onLogout()
            },

            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Sair")
        }
    }
}

@Composable
fun PhotoSlot(
    image: Int,
    title: String,
    description: String
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp),

        verticalAlignment = Alignment.CenterVertically
    ) {

        Column(
            modifier = Modifier
                .size(180.dp)
                .border(
                    width = 2.dp,
                    color = Color.Gray,
                    shape = RoundedCornerShape(8.dp)
                ),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(id = image),
                contentDescription = title,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier
                .padding(start = 20.dp)
                .weight(1f)
        ) {

            Text(
                text = title
            )

            Text(
                text = description,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}