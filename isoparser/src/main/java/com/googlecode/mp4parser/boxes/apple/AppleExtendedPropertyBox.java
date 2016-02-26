package com.googlecode.mp4parser.boxes.apple;

import com.googlecode.mp4parser.AbstractContainerBox;

import java.util.List;

/**
 * @author Mirko Klemm 2015-11-26
 */
public class AppleExtendedPropertyBox extends AbstractContainerBox {

	public AppleExtendedPropertyBox() {
		super("----");
	}

	public String getMean() {
		List<AppleExtendedMeanAtom> meanBox = getBoxes(AppleExtendedMeanAtom.class);
		return !meanBox.isEmpty() ? meanBox.get(0).getData() : null;
	}
	public String getName() {
		List<AppleExtendedNameAtom> nameBox = getBoxes(AppleExtendedNameAtom.class);
		return !nameBox.isEmpty() ? nameBox.get(0).getData() : null;
	}
	public String getData() {
		List<Utf8AppleDataAtom> dataBox = getBoxes(Utf8AppleDataAtom.class);
		return !dataBox.isEmpty() ? dataBox.get(0).getData() : null;
	}
}
