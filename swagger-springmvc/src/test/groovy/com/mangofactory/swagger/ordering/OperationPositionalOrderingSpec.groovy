package com.mangofactory.swagger.ordering

import com.google.common.collect.Ordering
import com.mangofactory.swagger.mixins.ApiOperationSupport
import com.wordnik.swagger.model.Operation
import spock.lang.Specification

@Mixin(ApiOperationSupport)
class OperationPositionalOrderingSpec extends Specification {
  def "positional order"() {
    given:
      Ordering<Operation> ordering = new OperationPositionalOrdering()

    when:
      println("")
      Collections.sort(list, ordering)
    then:
      list[0].method() == expectedFirst
      list[1].method() == expectedSecond

    where:
      list                                                  | expectedFirst | expectedSecond
      [operation(2, 'o2'), operation(0, 'o0')]              | 'o0'          | 'o2'
  }
}
