package com.cresloga.inventory.household.householdinventory.models.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Item
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-05-02T11:32:34.017Z[GMT]")
public class Item implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1786360010057792864L;

	@JsonProperty("id")
	private Integer id = null;

	@JsonProperty("name")
	private String name = null;

	@JsonProperty("quantity")
	private BigDecimal quantity = null;

	public Item id(Integer id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	@ApiModelProperty(example = "1", readOnly = true, value = "")

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Item name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Name of the item
	 * 
	 * @return name
	 **/
	@ApiModelProperty(example = "tomatoes", required = true, value = "Name of the item")
	@NotNull

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Item quantity(BigDecimal quantity) {
		this.quantity = quantity;
		return this;
	}

	/**
	 * Quantities in Kg
	 * 
	 * @return quantity
	 **/
	@ApiModelProperty(example = "5", required = true, value = "Quantities in Kg")
	@NotNull

	@Valid
	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Item item = (Item) o;
		return Objects.equals(this.id, item.id) && Objects.equals(this.name, item.name)
				&& Objects.equals(this.quantity, item.quantity);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, quantity);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Item {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
