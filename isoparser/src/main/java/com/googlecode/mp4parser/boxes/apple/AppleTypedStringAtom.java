package com.googlecode.mp4parser.boxes.apple;

import com.googlecode.mp4parser.AbstractBox;

import java.nio.ByteBuffer;

/**
 * @author Mirko Klemm 2015-11-26
 */
public abstract class AppleTypedStringAtom extends AbstractBox {
	private int dataType;

	public AppleTypedStringAtom(final String type, int dataType) {
		super(type);
		this.dataType = dataType;
	}

	protected abstract int getDataSize();
	protected abstract void writeData(final ByteBuffer buffer);
	protected abstract void parseData(final ByteBuffer buffer);

	@Override
	protected long getContentSize() {
		return getDataSize() + 4;
	}

	@Override
	protected void getContent(ByteBuffer content) {
		content.putInt(dataType);
		writeData(content);
	}


	@Override
	protected void _parseDetails(ByteBuffer content) {
        dataType = content.getInt();
		parseData(content);
	}

	@Override
	public String toString() {
		return "dataType=" + dataType + ", ";
	}
}
