package gmt.domain

import javax.persistence.*

@Entity
class MyOtherJpaDomain {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id

	@Column
    int myProperty

    static constraints = {
    }
}
