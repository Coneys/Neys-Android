package com.github.coneys.neys.app;

import android.annotation.SuppressLint;

import com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment;
import com.google.android.material.shape.ShapePath;

class BottomAppBarCutCornersTopEdge extends BottomAppBarTopEdgeTreatment {

  private final float fabMargin;
  private final float cradleVerticalOffset;

  BottomAppBarCutCornersTopEdge(
      float fabMargin, float roundedCornerRadius, float cradleVerticalOffset) {
    super(fabMargin, roundedCornerRadius, cradleVerticalOffset);
    this.fabMargin = fabMargin;
    this.cradleVerticalOffset = cradleVerticalOffset;
  }

  @Override
  @SuppressWarnings("RestrictTo")
  public void getEdgePath(float length, float center, float interpolation, ShapePath shapePath) {
    @SuppressLint("RestrictedApi") float fabDiameter = getFabDiameter();
    if (fabDiameter == 0) {
      shapePath.lineTo(length, 0);
      return;
    }

    float diamondSize = fabDiameter / 2f;
    @SuppressLint("RestrictedApi") float middle = center + getHorizontalOffset();

    float verticalOffsetRatio = cradleVerticalOffset / diamondSize;
    if (verticalOffsetRatio >= 1.0f) {
      shapePath.lineTo(length, 0);
      return;
    }

    shapePath.lineTo(middle - (fabMargin + diamondSize - cradleVerticalOffset), 0);

    shapePath.lineTo(middle, (diamondSize - cradleVerticalOffset + fabMargin) * interpolation);

    shapePath.lineTo(middle + (fabMargin + diamondSize - cradleVerticalOffset), 0);

    shapePath.lineTo(length, 0);
  }
}