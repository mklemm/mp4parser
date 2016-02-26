package com.googlecode.mp4parser.boxes.apple;

import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.coremedia.iso.Utf8;

import java.nio.ByteBuffer;

/**
 * @author Mirko Klemm 2015-11-27
 */
public abstract class Utf8AppleTypedStringAtom extends AppleTypedStringAtom {
	private String data;

	public Utf8AppleTypedStringAtom(final String type) {
		super(type, 1);
	}

	@Override
	protected int getDataSize() {
		return Utf8.utf8StringLengthInBytes(data);
	}

	@Override
	protected void writeData(ByteBuffer buffer) {
		IsoTypeWriter.writeUtf8String(buffer, data);
	}

	@Override
	protected void parseData(ByteBuffer buffer) {
		this.data = IsoTypeReader.readString(buffer, buffer.remaining());
	}

	public String getData() {
		if(!isParsed()) {
			parseDetails();
		}
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return super.toString() +
				"data='" + getData() + '\'' ;
	}
}
