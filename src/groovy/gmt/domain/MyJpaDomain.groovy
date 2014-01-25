package gmt.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class MyJpaDomain {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id

	@Column
    int myProperty

    static constraints = {
    }
}
