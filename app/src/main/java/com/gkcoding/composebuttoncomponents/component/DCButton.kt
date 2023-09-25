package com.gkcoding.composebuttoncomponents.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.Easing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.VectorConverter
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.interaction.FocusInteraction
import androidx.compose.foundation.interaction.HoverInteraction
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DCButton(
    onClick: () -> Unit,
    onLongClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.shape,
    colors: ButtonColors = ButtonDefaults.buttonColors(),
    elevation: ButtonElevation? = ButtonDefaults.buttonElevation(),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit
) {
    val containerColor = colors.containerColor(enabled).value
    val contentColor = colors.contentColor(enabled).value
    val shadowElevation = elevation?.shadowElevation(enabled, interactionSource)?.value ?: 0.dp
    val tonalElevation = elevation?.tonalElevation(enabled, interactionSource)?.value ?: 0.dp
    DCBSurface(
        onClick = onClick,
        onLongClick = onLongClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        color = containerColor,
        contentColor = contentColor,
        tonalElevation = tonalElevation,
        shadowElevation = shadowElevation,
        border = border,
        interactionSource = interactionSource
    ) {
        CompositionLocalProvider(LocalContentColor provides contentColor) {
            ProvideTextStyle(value = MaterialTheme.typography.labelLarge) {
                Row(
                    Modifier
                        .defaultMinSize(
                            minWidth = ButtonDefaults.MinWidth, minHeight = ButtonDefaults.MinHeight
                        )
                        .padding(contentPadding),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    content = content
                )
            }
        }
    }

}

@Composable
fun DCElevatedButton(
    onClick: () -> Unit,
    onLongClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.elevatedShape,
    colors: ButtonColors = ButtonDefaults.elevatedButtonColors(),
    elevation: ButtonElevation? = ButtonDefaults.elevatedButtonElevation(),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit
) =
    DCButton(
        onClick = onClick,
        onLongClick = onLongClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        content = content
    )

@Composable
fun DCFilledTonalButton(
    onClick: () -> Unit,
    onLongClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.filledTonalShape,
    colors: ButtonColors = ButtonDefaults.filledTonalButtonColors(),
    elevation: ButtonElevation? = ButtonDefaults.filledTonalButtonElevation(),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = androidx.compose.material3.ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit
) =
    DCButton(
        onClick = onClick,
        onLongClick = onLongClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        content = content
    )

@Composable
fun DCOutlinedButton(
    onClick: () -> Unit,
    onLongClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.outlinedShape,
    colors: ButtonColors = ButtonDefaults.outlinedButtonColors(),
    elevation: ButtonElevation? = null,
    border: BorderStroke? = ButtonDefaults.outlinedButtonBorder,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit
) =
    DCButton(
        onClick = onClick,
        onLongClick = onLongClick,
        modifier = modifier,
        enabled = enabled,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
        content = content
    )

@Composable
fun DCTextButton(
    onClick: () -> Unit,
    onLongClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = ButtonDefaults.textShape,
    colors: ButtonColors = ButtonDefaults.textButtonColors(),
    elevation: ButtonElevation? = null,
    border: BorderStroke? = null,
    contentPadding: PaddingValues = ButtonDefaults.TextButtonContentPadding,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable RowScope.() -> Unit
) = DCButton(
    onClick = onClick,
    onLongClick = onLongClick,
    modifier = modifier,
    enabled = enabled,
    shape = shape,
    colors = colors,
    elevation = elevation,
    border = border,
    contentPadding = contentPadding,
    interactionSource = interactionSource,
    content = content
)

object ButtonDefaults {
    private val TextButtonHorizontalPadding = 12.dp
    private val ButtonHorizontalPadding = 24.dp
    private val ButtonVerticalPadding = 8.dp
    val IconSize = 18.0.dp
    val IconSpacing = 8.dp
    val textShape: Shape = RoundedCornerShape(50)

    val shape: Shape = RoundedCornerShape(50)
    val outlinedShape: Shape = RoundedCornerShape(50)
    val filledTonalShape: Shape = RoundedCornerShape(50)
    val elevatedShape: Shape = RoundedCornerShape(50)
    val ContentPadding = PaddingValues(
        start = ButtonHorizontalPadding,
        top = ButtonVerticalPadding,
        end = ButtonHorizontalPadding,
        bottom = ButtonVerticalPadding
    )
    val MinWidth = 58.dp
    val MinHeight = 40.dp
    val TextButtonContentPadding = PaddingValues(
        start = TextButtonHorizontalPadding,
        top = ContentPadding.calculateTopPadding(),
        end = TextButtonHorizontalPadding,
        bottom = ContentPadding.calculateBottomPadding()
    )

    @Composable
    fun buttonColors(
        containerColor: Color = MaterialTheme.colorScheme.primary,
        contentColor: Color = MaterialTheme.colorScheme.onPrimary,
        disabledContainerColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
        disabledContentColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
    ): ButtonColors = ButtonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )

    @Composable
    fun elevatedButtonColors(
        containerColor: Color = MaterialTheme.colorScheme.surface,
        contentColor: Color = MaterialTheme.colorScheme.primary,
        disabledContainerColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = 0.12f),
        disabledContentColor: Color = MaterialTheme.colorScheme.onSurface
            .copy(alpha = 0.38f),
    ): ButtonColors = ButtonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )

    @Composable
    fun filledTonalButtonColors(
        containerColor: Color = MaterialTheme.colorScheme.secondaryContainer,
        contentColor: Color = MaterialTheme.colorScheme.onSecondaryContainer,
        disabledContainerColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.12f),
        disabledContentColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
    ): ButtonColors = ButtonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )

    @Composable
    fun outlinedButtonColors(
        containerColor: Color = Color.Transparent,
        contentColor: Color = MaterialTheme.colorScheme.primary,
        disabledContainerColor: Color = Color.Transparent,
        disabledContentColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
    ): ButtonColors = ButtonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )

    @Composable
    fun textButtonColors(
        containerColor: Color = Color.Transparent,
        contentColor: Color = MaterialTheme.colorScheme.primary,
        disabledContainerColor: Color = Color.Transparent,
        disabledContentColor: Color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f),
    ): ButtonColors = ButtonColors(
        containerColor = containerColor,
        contentColor = contentColor,
        disabledContainerColor = disabledContainerColor,
        disabledContentColor = disabledContentColor
    )

    @Composable
    fun buttonElevation(
        defaultElevation: Dp = 0.0.dp,
        pressedElevation: Dp = 0.0.dp,
        focusedElevation: Dp = 0.0.dp,
        hoveredElevation: Dp = 1.0.dp,
        disabledElevation: Dp = 0.0.dp,
    ): ButtonElevation = ButtonElevation(
        defaultElevation = defaultElevation,
        pressedElevation = pressedElevation,
        focusedElevation = focusedElevation,
        hoveredElevation = hoveredElevation,
        disabledElevation = disabledElevation,
    )

    @Composable
    fun elevatedButtonElevation(
        defaultElevation: Dp = 1.0.dp,
        pressedElevation: Dp = 1.0.dp,
        focusedElevation: Dp = 1.0.dp,
        hoveredElevation: Dp = 3.0.dp,
        disabledElevation: Dp = 0.dp
    ): ButtonElevation = ButtonElevation(
        defaultElevation = defaultElevation,
        pressedElevation = pressedElevation,
        focusedElevation = focusedElevation,
        hoveredElevation = hoveredElevation,
        disabledElevation = disabledElevation
    )

    @Composable
    fun filledTonalButtonElevation(
        defaultElevation: Dp = 0.0.dp,
        pressedElevation: Dp = 0.0.dp,
        focusedElevation: Dp = 0.0.dp,
        hoveredElevation: Dp = 1.0.dp,
        disabledElevation: Dp = 0.dp
    ): ButtonElevation = ButtonElevation(
        defaultElevation = defaultElevation,
        pressedElevation = pressedElevation,
        focusedElevation = focusedElevation,
        hoveredElevation = hoveredElevation,
        disabledElevation = disabledElevation
    )

    val outlinedButtonBorder: BorderStroke
        @Composable
        get() = BorderStroke(
            width = 1.0.dp,
            color = MaterialTheme.colorScheme.outline,
        )

}


@Stable
class ButtonElevation internal constructor(
    private val defaultElevation: Dp,
    private val pressedElevation: Dp,
    private val focusedElevation: Dp,
    private val hoveredElevation: Dp,
    private val disabledElevation: Dp,
) {
    @Composable
    internal fun tonalElevation(enabled: Boolean, interactionSource: InteractionSource): State<Dp> {
        return animateElevation(enabled = enabled, interactionSource = interactionSource)
    }

    @Composable
    internal fun shadowElevation(
        enabled: Boolean, interactionSource: InteractionSource
    ): State<Dp> {
        return animateElevation(enabled = enabled, interactionSource = interactionSource)
    }

    @Composable
    private fun animateElevation(
        enabled: Boolean, interactionSource: InteractionSource
    ): State<Dp> {
        val interactions = remember { mutableStateListOf<Interaction>() }
        LaunchedEffect(interactionSource) {
            interactionSource.interactions.collect { interaction ->
                when (interaction) {
                    is HoverInteraction.Enter -> {
                        interactions.add(interaction)
                    }

                    is HoverInteraction.Exit -> {
                        interactions.remove(interaction.enter)
                    }

                    is FocusInteraction.Focus -> {
                        interactions.add(interaction)
                    }

                    is FocusInteraction.Unfocus -> {
                        interactions.remove(interaction.focus)
                    }

                    is PressInteraction.Press -> {
                        interactions.add(interaction)
                    }

                    is PressInteraction.Release -> {
                        interactions.remove(interaction.press)
                    }

                    is PressInteraction.Cancel -> {
                        interactions.remove(interaction.press)
                    }
                }
            }
        }

        val interaction = interactions.lastOrNull()

        val target = if (!enabled) {
            disabledElevation
        } else {
            when (interaction) {
                is PressInteraction.Press -> pressedElevation
                is HoverInteraction.Enter -> hoveredElevation
                is FocusInteraction.Focus -> focusedElevation
                else -> defaultElevation
            }
        }

        val animatable = remember { Animatable(target, Dp.VectorConverter) }

        if (!enabled) {
            // No transition when moving to a disabled state
            LaunchedEffect(target) { animatable.snapTo(target) }
        } else {
            LaunchedEffect(target) {
                val lastInteraction = when (animatable.targetValue) {
                    pressedElevation -> PressInteraction.Press(Offset.Zero)
                    hoveredElevation -> HoverInteraction.Enter()
                    focusedElevation -> FocusInteraction.Focus()
                    else -> null
                }
                animatable.animateElevation(
                    from = lastInteraction, to = interaction, target = target
                )
            }
        }

        return animatable.asState()
    }

    private suspend fun Animatable<Dp, *>.animateElevation(
        target: Dp, from: Interaction? = null, to: Interaction? = null
    ) {
        val spec = when {
            to != null -> ElevationDefaults.incomingAnimationSpecForInteraction(to)
            from != null -> ElevationDefaults.outgoingAnimationSpecForInteraction(from)
            else -> null
        }
        if (spec != null) animateTo(target, spec) else snapTo(target)
    }

    object ElevationDefaults {
        fun incomingAnimationSpecForInteraction(interaction: Interaction): AnimationSpec<Dp>? {
            return when (interaction) {
                is PressInteraction.Press -> DefaultIncomingSpec
                is DragInteraction.Start -> DefaultIncomingSpec
                is HoverInteraction.Enter -> DefaultIncomingSpec
                is FocusInteraction.Focus -> DefaultIncomingSpec
                else -> null
            }
        }

        private val OutgoingSpecEasing: Easing = CubicBezierEasing(0.40f, 0.00f, 0.60f, 1.00f)

        private val DefaultIncomingSpec = TweenSpec<Dp>(
            durationMillis = 120, easing = FastOutSlowInEasing
        )

        private val DefaultOutgoingSpec = TweenSpec<Dp>(
            durationMillis = 150, easing = OutgoingSpecEasing
        )

        private val HoveredOutgoingSpec = TweenSpec<Dp>(
            durationMillis = 120, easing = OutgoingSpecEasing
        )

        /**
         * Returns the [AnimationSpec]s used when animating elevation away from [interaction], to the
         * default state. If [interaction] is unknown, then returns `null`.
         *
         * @param interaction the [Interaction] that is being animated away from
         */
        fun outgoingAnimationSpecForInteraction(interaction: Interaction): AnimationSpec<Dp>? {
            return when (interaction) {
                is PressInteraction.Press -> DefaultOutgoingSpec
                is DragInteraction.Start -> DefaultOutgoingSpec
                is HoverInteraction.Enter -> HoveredOutgoingSpec
                is FocusInteraction.Focus -> DefaultOutgoingSpec
                else -> null
            }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is ButtonElevation) return false

        if (defaultElevation != other.defaultElevation) return false
        if (pressedElevation != other.pressedElevation) return false
        if (focusedElevation != other.focusedElevation) return false
        if (hoveredElevation != other.hoveredElevation) return false
        if (disabledElevation != other.disabledElevation) return false

        return true
    }

    override fun hashCode(): Int {
        var result = defaultElevation.hashCode()
        result = 31 * result + pressedElevation.hashCode()
        result = 31 * result + focusedElevation.hashCode()
        result = 31 * result + hoveredElevation.hashCode()
        result = 31 * result + disabledElevation.hashCode()
        return result
    }
}

@Immutable
class ButtonColors internal constructor(
    private val containerColor: Color,
    private val contentColor: Color,
    private val disabledContainerColor: Color,
    private val disabledContentColor: Color,
) {

    @Composable
    internal fun containerColor(enabled: Boolean): State<Color> {
        return rememberUpdatedState(if (enabled) containerColor else disabledContainerColor)
    }

    @Composable
    internal fun contentColor(enabled: Boolean): State<Color> {
        return rememberUpdatedState(if (enabled) contentColor else disabledContentColor)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is ButtonColors) return false

        if (containerColor != other.containerColor) return false
        if (contentColor != other.contentColor) return false
        if (disabledContainerColor != other.disabledContainerColor) return false
        if (disabledContentColor != other.disabledContentColor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = containerColor.hashCode()
        result = 31 * result + contentColor.hashCode()
        result = 31 * result + disabledContainerColor.hashCode()
        result = 31 * result + disabledContentColor.hashCode()
        return result
    }
}