package com.hayatibahar.composeplayground.ui.components

import androidx.compose.foundation.Indication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

private val RippleRadius = 24.dp

@Composable
fun IndicatingIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    indication: Indication = rememberRipple(bounded = false, radius = RippleRadius),
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .clickable(
                onClick = onClick,
                enabled = enabled,
                role = Role.Button,
                interactionSource = interactionSource,
                indication = indication
            ),
        contentAlignment = Alignment.Center
    ) {
        val contentColor = if (enabled) {
            LocalContentColor.current.copy(alpha = 1f)
        } else {
            LocalContentColor.current.copy(alpha = 0f)
        }
        CompositionLocalProvider(LocalContentColor provides contentColor, content = content)
    }
}