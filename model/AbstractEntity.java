package model;

import java.time.LocalDate;
import java.util.Objects;

public abstract class AbstractEntity {

	protected String id;
	protected LocalDate createdDate;
	protected LocalDate lastModifyDate;
	protected int row;
	protected boolean isRemoved = false;
	
	public AbstractEntity(String id, LocalDate createdDate, LocalDate lastModifyDate) {
		super();
		this.id = id;
		this.createdDate = createdDate;
		this.lastModifyDate = lastModifyDate;
	}
	
	public AbstractEntity() {
		super();
		this.id = "";
		this.createdDate = null;
		this.lastModifyDate = null;
	}
	
	public String getId() {
		return id;
	}
	
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	
	public LocalDate getLastModifyDate() {
		return lastModifyDate;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}
	
	private void remove() {
		this.isRemoved = true;
	}

	public boolean isRemoved() {
		return isRemoved;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractEntity other = (AbstractEntity) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
